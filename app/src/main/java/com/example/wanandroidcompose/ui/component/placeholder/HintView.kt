package com.example.wanandroidcompose.ui.component.placeholder

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun HintView(modifier: Modifier,icon:ImageVector,hint:String){
    Box(modifier = modifier, contentAlignment = Alignment.Center){
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Icon(imageVector = icon, contentDescription = "error")
            Text(text = hint)
        }
    }

}