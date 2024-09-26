package com.example.wanandroidcompose.ui.component.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MenuItem(
    modifier: Modifier,
    leadingIcon: ImageVector,
    string: String,
    trailingIcon: ImageVector?
) {
    Row(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surfaceBright)
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = leadingIcon,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onSurface
        )
        Text(
            modifier = Modifier
                .weight(1F)
                .padding(horizontal = 12.dp), text = string,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleMedium
        )
        trailingIcon?.let {
            Icon(
                imageVector = Icons.Rounded.ArrowForwardIos,
                contentDescription = "",
                modifier = Modifier.size(12.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )
        }

    }
}