package com.example.wanandroidcompose.ui.component.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.wanandroidcompose.common.clickableWithoutRipple

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    title: String,
    contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
    backgroundColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    showDividerLine: Boolean = true,
    titleSize: TextUnit? = null,
    onBack: (() -> Unit)? = null,
    extraFunction: Pair<ImageVector, () -> Unit>? = null
) {
    Box(
        Modifier
            .fillMaxWidth()
            .background(backgroundColor)
    ) {
        Box(
            modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 12.dp)
        ) {
            onBack?.let {
                Box(
                    Modifier
                        .align(Alignment.CenterStart)
                ) {
                    Icon(
                        Icons.Rounded.ArrowBackIosNew,
                        contentDescription = "返回",
                        modifier = Modifier
                            .clickableWithoutRipple { it.invoke() }
                            .size(20.dp),
                        tint = contentColor
                    )
                }
            }

            Text(
                text = title,
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.titleMedium,
                fontSize = titleSize ?: TextUnit.Unspecified,
                color = contentColor
            )
            extraFunction?.let {
                Box(
                    Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 12.dp)
                ) {
                    Icon(
                        it.first,
                        contentDescription = "设置",
                        modifier = Modifier
                            .clickableWithoutRipple { it.second() }
                            .size(20.dp),
                        tint = contentColor
                    )
                }
            }
        }

        if (showDividerLine){
            HorizontalDivider(
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.1F),
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }

}
