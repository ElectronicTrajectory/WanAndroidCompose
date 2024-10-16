package com.example.wanandroidcompose.ui.component.common

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cached
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.wanandroidcompose.ui.theme.AppTheme

@Composable
fun RotateView(size: Dp = 20.dp, icon: ImageVector, color: Color, direction: Boolean = true) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val angle by infiniteTransition.animateFloat(
        initialValue = if (direction) 360f else 0f,
        targetValue = if (direction) 0f else 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )
    Icon(
        imageVector = icon,
        contentDescription = "Loading Icon",
        modifier = Modifier
            .size(size)
            .graphicsLayer { rotationZ = angle }, // 应用旋转角度
        tint = color
    )
}

@Preview
@Composable
private fun RotateViewPreview() {
    AppTheme {
        RotateView(20.dp, Icons.Default.Cached, Color.LightGray,true)
    }
}