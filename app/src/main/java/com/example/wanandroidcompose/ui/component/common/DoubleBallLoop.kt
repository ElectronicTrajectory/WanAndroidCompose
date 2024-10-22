package com.example.wanandroidcompose.ui.component.common

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wanandroidcompose.ui.theme.AppTheme
import kotlin.math.PI
import kotlin.math.sin

/**
 * @param baseLength 基准长度,用于计算圆形的半径,组件的宽高
 * @param scaleRangeStep 用于计算圆球的缩放程度
 * @param color1 球1的颜色
 * @param color2 球2的颜色
 * @param millis 走完一个循环需要的时间
 */
@Composable
fun DoubleBallLoop(
    baseLength: Float,
    scaleRangeStep: Float,
    color1: Color,
    color2: Color,
    millis: Int = 1000
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val scaleAnimate by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 2F,
        animationSpec = infiniteRepeatable(
            animation = tween(millis, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )
    val translateAnimate by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 1F,
        animationSpec = infiniteRepeatable(
            animation = tween(millis / 2, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val ballRadius = baseLength / 2

    val translateFactor = ballRadius * 2

    val offsetX1 = translateFactor * translateAnimate
    val offsetX2 = translateFactor * translateAnimate * -1

    val baseScale = 1 - scaleRangeStep
    val scaleOffset = getScaleOffset(scaleAnimate, scaleRangeStep)

    val scale1 = baseScale + scaleOffset
    val scale2 = baseScale - scaleOffset

    val blendMode = BlendMode.Multiply

    val density = LocalDensity.current.density
    val ballRadiusPx = ballRadius * density

    Box(modifier = Modifier.size((baseLength * 2).dp, baseLength.dp)) {
        Box(
            modifier = Modifier
                .width((ballRadius * 4).dp)
                .height((ballRadius * 2).dp)
                .clip(RectangleShape)
                .align(Alignment.Center)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                if (scaleAnimate >= 1) {
                    drawBall(color1, (ballRadius + offsetX1), ballRadiusPx, scale1, blendMode)
                }
                drawBall(color2, (3 * ballRadius + offsetX2), ballRadiusPx, scale2, blendMode)
                if (scaleAnimate < 1) {
                    drawBall(color1, (ballRadius + offsetX1), ballRadiusPx, scale1, blendMode)
                }
            }
        }
    }

}

/**
 * @param color 圆球颜色
 * @param offsetX X轴偏移量
 * @param ballRadiusPx 圆球半径的像素值
 * @param scale 缩放比例
 * @param blendMode 混合模式
 */
private fun DrawScope.drawBall(
    color: Color,
    offsetX: Float,
    ballRadiusPx: Float,
    scale: Float,
    blendMode: BlendMode
) {
    drawCircle(
        color = color,
        center = Offset(offsetX * density, ballRadiusPx),
        radius = ballRadiusPx * scale,
        blendMode = blendMode
    )
}

private fun getScaleOffset(progress: Float, step: Float): Float {
    require(step >= -1 && step <= 1) { throw Exception("step must in [-1,1]") }
    return sin(progress * PI).toFloat() * step
}


private fun getPercent1(progress: Float, minValue: Float, midValue: Float, maxValue: Float): Float {
    val gapMinMid = (midValue - minValue)
    val gapMidMax = (maxValue - midValue)
    return when (progress) {
        in -1F..-0.6F -> midValue + (progress + 1F) / 0.4F * gapMidMax  // [-1, -0.6] 百分比均匀增大到maxValue
        in -0.6F..-0.4F -> maxValue  // [-0.6, -0.4] 百分比不变，固定为maxValue
        in -0.4F..0F -> maxValue - (progress + 0.4F) / 0.4F * gapMidMax // [-0.4, 0] 百分比均匀减小到midValue
        in 0F..0.4F -> midValue - progress / 0.4F * gapMinMid  // [0, 0.4] 百分比均匀减小到minValue
        in 0.4F..0.6F -> minValue  // [0.4, 0.6] 百分比不变，固定为maxValue
        in 0.6F..1F -> minValue + (progress - 0.6F) / 0.4F * gapMinMid  // [0.6, 1] 百分比均匀增大到midValue
        else -> 0.6F  // 超出范围，默认返回0.6
    }
}

private fun getPercent2(progress: Float, minValue: Float, midValue: Float, maxValue: Float): Float {
    val gapMinMid = (midValue - minValue)
    val gapMidMax = (maxValue - midValue)
    return when (progress) {
        in -1F..-0.6F -> midValue - (progress + 1F) / 0.4F * gapMinMid  // [-1, -0.6] 百分比均匀减小到minValue
        in -0.6F..-0.4F -> minValue  // [-0.6, -0.4] 百分比不变，固定为minValue
        in -0.4F..0F -> minValue + (progress + 0.4F) / 0.4F * gapMinMid // [-0.4, 0] 百分比均匀增大到midValue
        in 0F..0.4F -> midValue + progress / 0.4F * gapMidMax  // [0, 0.4] 百分比均匀增大到maxValue
        in 0.4F..0.6F -> maxValue  // [0.4, 0.6] 百分比不变，固定为maxValue
        in 0.6F..1F -> maxValue - (progress - 0.6F) / 0.4F * gapMidMax  // [0.6, 1] 百分比均匀减小到midValue
        else -> 0.6F  // 超出范围，默认返回0.6
    }
}

@Preview(widthDp = 600, heightDp = 600)
@Composable
private fun DoubleBallLoopPreview() {
    AppTheme {
        Box(Modifier.background(Color.White), contentAlignment = Alignment.Center) {
            DoubleBallLoop(baseLength = 200F, 0.2F, Color(0xFFFF2B55), Color(0xFF27FCFF),1800)
        }
    }
}
