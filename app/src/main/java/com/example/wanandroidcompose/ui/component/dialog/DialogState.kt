package com.example.wanandroidcompose.ui.component.dialog

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.example.wanandroidcompose.ui.theme.Cancel

@Stable
interface DialogState {
    /**
     * 是否显示
     */
    val visible: Boolean

    /**
     * 显示对话框
     */
    fun show(
        title: String,
        content: String? = null,
        okText: String? = null,
        cancelText: String? = null,
        okColor: Color = Cancel,
        closeOnAction: Boolean = true,
        onCancel: (() -> Unit)? = {},
        onOk: (() -> Unit)? = null,
        extra: (@Composable BoxScope.() -> Unit)? = null
    )

    /**
     * 隐藏对话框
     */
    fun hide()
}

@Stable
interface MyDialogState {
    val visible: Boolean
    fun show(dismissOnClickOutside: Boolean = true, content: (@Composable BoxScope.() -> Unit))
    fun hide()
}