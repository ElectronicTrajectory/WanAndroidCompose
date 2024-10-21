package com.example.wanandroidcompose.ui.component.dialog

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

internal class DialogStateImpl : DialogState {
    override var visible by mutableStateOf(false)

    var props by mutableStateOf<DialogProps?>(null)
        private set

    override fun show(
        title: String,
        content: String?,
        okText: String?,
        cancelText: String?,
        okColor: Color,
        closeOnAction: Boolean,
        onCancel: (() -> Unit)?,
        onOk: (() -> Unit)?,
        extra: (@Composable BoxScope.() -> Unit)?
    ) {
        props = DialogProps(
            title,
            content,
            okText,
            cancelText,
            okColor,
            closeOnAction,
            onCancel,
            onOk,
            extra
        )
        visible = true
    }

    override fun hide() {
        visible = false
    }
}

internal data class DialogProps(
    val title: String,
    val content: String?,
    val okText: String?,
    val cancelText: String?,
    val okColor: Color,
    val closeOnAction: Boolean,
    val onCancel: (() -> Unit)?,
    val onOk: (() -> Unit)?,
    var extra: (@Composable BoxScope.() -> Unit)? = null
)


internal class MyDialogStateImpl : MyDialogState {
    override var visible by mutableStateOf(false)
    var props by mutableStateOf<MyDialogProps?>(null)
        private set

    override fun show(dismissOnClickOutside: Boolean, content: @Composable (BoxScope.() -> Unit)) {
        props = MyDialogProps(dismissOnClickOutside, content)
        visible = true
    }

    override fun hide() {
        visible = false
    }

}

internal data class MyDialogProps(
    val dismissOnClickOutside: Boolean,
    val content: (@Composable BoxScope.() -> Unit)
)