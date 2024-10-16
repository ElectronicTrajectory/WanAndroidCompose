package com.example.wanandroidcompose.ui.component.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowUpward

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wanandroidcompose.R
import com.example.wanandroidcompose.ui.theme.AppTheme

@Composable
fun FloatButton(
    modifier: Modifier,
    icon: ImageVector,
    iconColor: Color,
    bgColor: Color = Color.Gray,
    desc:String = stringResource(id = R.string.float_btn)
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

@Preview
@Composable
private fun FloatButtonPreview() {
    AppTheme {
        FloatButton(Modifier, Icons.Rounded.ArrowUpward, Color.Black, Color.LightGray)
    }
}