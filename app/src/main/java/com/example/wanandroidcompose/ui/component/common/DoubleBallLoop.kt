package com.example.wanandroidcompose.ui.component.common

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wanandroidcompose.ui.theme.AppTheme
import kotlin.math.abs

@Composable
fun DoubleBallLoop() {

    val millis = 10000
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
            animation = tween(millis/2, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    //progress 范围为 -1~1
    val progress = scaleAnimate - 1F

    val ballRadius = 100F
    val totalWidth = ballRadius * 1.5
    val totalHeight = ballRadius * 2

    val color1 = Color.Red
    val color2 = Color.Cyan

    val translateXishu = 200F


    val offsetX1 = translateXishu * translateAnimate
    val offsetX2 = translateXishu * translateAnimate * -1

//    val offsetX1 = 0
//    val offsetX2 = 0

    val scale1 =
        when (progress) {
            in -1F..-0.6F -> 0.6F + (progress + 1F) / 0.4F * 0.3F  // [-1, -0.6] 百分比均匀增大到0.9
            in -0.6F..-0.4F -> 0.9F  // [-0.6, -0.4] 百分比不变，固定为0.9
            in -0.4F..0F -> 0.9F - (progress + 0.4F) / 0.4F * 0.3F  // [-0.4, 0] 百分比均匀减小到0.6
            in 0F..0.4F -> 0.6F - progress / 0.4F * 0.3F  // [0, 0.4] 百分比均匀减小到0.3
            in 0.4F..0.6F -> 0.3F  // [0.4, 0.6] 百分比不变，固定为0.3
            in 0.6F..1F -> 0.3F + (progress - 0.6F) / 0.4F * 0.3F  // [0.6, 1] 百分比均匀增大到0.6
            else -> 0.6F  // 超出范围，默认返回0.6
        }

    val scale2 =
//        getPercent(progress,0.6F,0.8F,1F)
        when (progress) {
            in -1F..-0.6F -> 0.6F - (progress + 1F) / 0.4F * 0.3F  // [-1, -0.6] 百分比均匀减小到0.3
            in -0.6F..-0.4F -> 0.3F  // [-0.6, -0.4] 百分比不变，固定为0.3
            in -0.4F..0F -> 0.3F + (progress + 0.4F) / 0.4F * 0.3F  // [-0.4, 0] 百分比均匀增大到0.6
            in 0F..0.4F -> 0.6F + progress / 0.4F * 0.3F  // [0, 0.4] 百分比均匀增大到0.9
            in 0.4F..0.6F -> 0.9F  // [0.4, 0.6] 百分比不变，固定为0.9
            in 0.6F..1F -> 0.9F - (progress - 0.6F) / 0.4F * 0.3F  // [0.6, 1] 百分比均匀减小到0.6
            else -> 0.6F  // 超出范围，默认返回0.6
        }

    Box(modifier = Modifier.size((totalWidth).dp, (totalHeight).dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color1,
                center = Offset((ballRadius + offsetX1) * density, ballRadius * density),
                radius = ballRadius * density *scale1,
                blendMode = BlendMode.ColorDodge
            )

            drawCircle(
                color2,
                center = Offset((3 * ballRadius + offsetX2) * density, ballRadius * density),
                radius = ballRadius * density *scale2,
                blendMode = BlendMode.Screen
            )


        }
    }
}

private fun getPercent(progress:Float, minValue: Float, midValue: Float, maxValue: Float):Float{
    val gapMinMid = (midValue-minValue)
    val gapMidMax = (maxValue-midValue)
    return when (progress) {
        in -1F..-0.6F -> midValue - (progress + 1F) / 0.4F * gapMinMid  // [-1, -0.6] 百分比均匀减小到0.3
        in -0.6F..-0.4F -> minValue  // [-0.6, -0.4] 百分比不变，固定为0.3
        in -0.4F..0F -> minValue + (progress + 0.4F) / 0.4F * gapMinMid // [-0.4, 0] 百分比均匀增大到0.6
        in 0F..0.4F -> midValue + progress / 0.4F * gapMidMax  // [0, 0.4] 百分比均匀增大到0.9
        in 0.4F..0.6F ->maxValue  // [0.4, 0.6] 百分比不变，固定为0.9
        in 0.6F..1F -> maxValue - (progress - midValue) / 0.4F * gapMidMax  // [0.6, 1] 百分比均匀减小到0.6
        else -> 0.6F  // 超出范围，默认返回0.6
    }
}

@Preview(widthDp = 400, heightDp = 200)
@Composable
private fun DoubleBallLoopPreview() {
    AppTheme {
        DoubleBallLoop()
    }
}