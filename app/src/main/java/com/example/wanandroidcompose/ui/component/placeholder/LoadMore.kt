package com.example.wanandroidcompose.ui.component.placeholder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wanandroidcompose.R
import com.example.wanandroidcompose.ui.component.common.RotateView
import com.example.wanandroidcompose.ui.theme.AppTheme

enum class LoadMoreState{
    LOADING,
    FAIL,
}

@Composable
fun LoadMore(state :LoadMoreState) {
    val contentColor = MaterialTheme.colorScheme.onSecondaryContainer
    val hint:String
    val icon:ImageVector
    val rotate:Boolean
    when(state){
        LoadMoreState.LOADING->{
            hint = stringResource(id = R.string.load_list_load_more)
            icon = Icons.Default.Sync
            rotate = true
        }
        LoadMoreState.FAIL->{
            hint = stringResource(id = R.string.load_list_load_error)
            icon = Icons.Default.ErrorOutline
            rotate = false

        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 12.dp
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = hint, color = contentColor)
        Spacer(modifier = Modifier.width(20.dp))
        if (rotate) {
            RotateView(icon = icon, color = contentColor)
        } else {
            Icon(imageVector = icon, contentDescription = "", tint = contentColor)
        }
    }
}
@Preview
@Composable
private fun LoadMorePreview(){
    AppTheme {
        LoadMore(LoadMoreState.LOADING)
    }
}