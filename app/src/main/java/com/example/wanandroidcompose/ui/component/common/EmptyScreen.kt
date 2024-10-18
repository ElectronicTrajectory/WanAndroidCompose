package com.example.wanandroidcompose.ui.component.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wanandroidcompose.R
import com.example.wanandroidcompose.ui.theme.AppTheme

@Composable
fun EmptyScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            DoubleBallLoop(50F,0.2f,MaterialTheme.colorScheme.tertiary,MaterialTheme.colorScheme.primary)
            Text(text = stringResource(id = R.string.face_text), style = MaterialTheme.typography.displaySmall)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(id = R.string.wait_for_develop), style = MaterialTheme.typography.displaySmall)
        }
    }
}


@Preview
@Composable
private fun EmptyScreenPreview() {
    AppTheme {
        Surface {
            EmptyScreen()
        }
    }
}