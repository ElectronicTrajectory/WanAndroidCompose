package com.example.wanandroidcompose.ui.component.placeholder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cached
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Refresh
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

enum class HintViewState {
    LOADING,
    FAIL,
    EMPTY
}

@Composable
fun HintView(modifier: Modifier, state: HintViewState) {
    val icon: ImageVector
    val hint: String
    when (state) {
        HintViewState.LOADING -> {
            icon = Icons.Default.Cached
            hint = stringResource(id = R.string.load_list_loading)
        }

        HintViewState.FAIL -> {
            icon = Icons.Default.Error
            hint = stringResource(id = R.string.load_list_load_error)
        }

        HintViewState.EMPTY -> {
            icon = Icons.Default.Error
            hint = stringResource(id = R.string.load_list_empty)
        }
    }
    val backgroundColor = MaterialTheme.colorScheme.secondary
    val contentColor = MaterialTheme.colorScheme.onSecondary
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(backgroundColor, MaterialTheme.shapes.medium)
                .padding(horizontal = 40.dp, vertical = 20.dp)
        ) {
            when (state) {
                HintViewState.LOADING -> {
                    RotateView(size = 30.dp, icon = icon, color = contentColor)
                }

                HintViewState.FAIL, HintViewState.EMPTY -> {
                    Icon(imageVector = icon, contentDescription = "error", tint = contentColor)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = hint, color = contentColor)
        }
    }

}

@Preview
@Composable
private fun HintViewPreview() {
    AppTheme {
        HintView(Modifier, HintViewState.LOADING)
    }
}