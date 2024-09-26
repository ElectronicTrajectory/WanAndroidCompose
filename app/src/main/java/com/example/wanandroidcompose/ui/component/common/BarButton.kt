package com.example.wanandroidcompose.ui.component.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

@Composable
fun BarButton(
    modifier: Modifier,
    title: String,
    textColor: Color,
    bgColor: Color,
    roundCorner: Dp? = null,
    fontSize: TextUnit? = null,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .background(
                bgColor,
                if (roundCorner != null) RoundedCornerShape(roundCorner) else MaterialTheme.shapes.medium
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            color = textColor,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = fontSize ?: TextUnit.Unspecified
        )
    }
}
