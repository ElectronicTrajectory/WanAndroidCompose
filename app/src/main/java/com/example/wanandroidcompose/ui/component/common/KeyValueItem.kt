package com.example.wanandroidcompose.ui.component.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun KeyValueItem(modifier: Modifier, key: String, value: String) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(text = key, style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.weight(1F))
        Text(text = value, style = MaterialTheme.typography.bodySmall)
    }
}