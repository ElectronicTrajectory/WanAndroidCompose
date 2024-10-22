package com.example.wanandroidcompose.ui.component.common

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.wanandroidcompose.R
import com.example.wanandroidcompose.ui.theme.AppTheme

@Composable
fun FloatButton(
    modifier: Modifier,
    icon: ImageVector,
    iconColor: Color,
    bgColor: Color = Color.Gray,
    desc: String = stringResource(id = R.string.float_btn)
) {
    Box(
        modifier = modifier
            .size(50.dp)
            .background(bgColor, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = desc,
            tint = iconColor,
            modifier = Modifier.size(30.dp)
        )
    }
}

@Composable
fun FloatButtonWithProgress(
    modifier: Modifier,
    icon: ImageVector,
    iconColor: Color,
    bgColor: Color,
    progressColor: Color,
    strokeWidth: Dp,
    progress: Float?,
    desc: String = stringResource(id = R.string.float_btn)
) {
    val animatedProgress = if (progress != null) {
        animateFloatAsState(
            targetValue = progress,
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
            label = ""
        )
    } else {
        null
    }
    Box(
        modifier = modifier
            .size(50.dp)
            .background(bgColor, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = desc,
            tint = iconColor,
            modifier = Modifier.size(30.dp)
        )
        animatedProgress?.let {
            CircularProgressIndicator(
                modifier = Modifier.fillMaxSize(),
                progress = animatedProgress.value,
                strokeCap = StrokeCap.Round,
                strokeWidth = strokeWidth,
                color = progressColor,
                backgroundColor = Color.Transparent
            )
        }
    }
}

@Preview
@Composable
private fun FloatButtonPreview() {
    AppTheme {
//        FloatButton(Modifier, Icons.Rounded.ArrowUpward, Color.Black, Color.LightGray)
        FloatButtonWithProgress(
            modifier = Modifier
                .padding(end = 12.dp, bottom = 12.dp)
                .clickable { },
            icon = Icons.Rounded.ArrowBackIosNew,
            iconColor = MaterialTheme.colorScheme.onSecondary,
            bgColor = Color.Gray,
            progressColor = Color.Cyan,
            strokeWidth = 4.dp,
            progress = 0.2F
        )
    }
}


//@Composable
//fun ProgressLinearDemo() {
//    val rememberProgress = remember { mutableStateOf(0.1f) }
//
//    //添加动画
//    val animatedProgress = animate(
//        target = rememberProgress.value,
//        animSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
//    )
//
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        LinearProgressIndicator(
//            progress = animatedProgress
//        )
//
//        Spacer(Modifier.height(30.dp))
//        TextButton(onClick = {
//            if (rememberProgress.value < 1f) rememberProgress.value += 0.1f
//        }) {
//            Text(text = "增加进度")
//        }
//    }
//}
