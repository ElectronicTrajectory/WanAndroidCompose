package com.example.wanandroidcompose.ui.component.placeholder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun HintView(modifier: Modifier, icon: ImageVector, hint: String) {
    val bgc = MaterialTheme.colorScheme.secondary
    val contentC = MaterialTheme.colorScheme.onSecondary
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(bgc, MaterialTheme.shapes.medium)
                .padding(horizontal = 40.dp, vertical = 20.dp)
        ) {
            Icon(imageVector = icon, contentDescription = "error", tint = contentC)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = hint, color = contentC)
        }
    }

}