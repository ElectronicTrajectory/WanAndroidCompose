package com.example.wanandroidcompose.ui.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.wanandroidcompose.ui.theme.AppTheme

@Composable
fun MyDialog(
    onDismiss: () -> Unit,
    dismissOnClickOutside: Boolean,
    content: (@Composable BoxScope.() -> Unit)
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnClickOutside = dismissOnClickOutside,
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .fillMaxWidth(0.8f)
                .background(MaterialTheme.colorScheme.primaryContainer),
            content = content
        )
    }
}

@PreviewLightDark
@Composable
private fun MyDialogPreview() {
    AppTheme {
        MyDialog(
            onDismiss = {},
            false,
            content = {}
        )
    }
}