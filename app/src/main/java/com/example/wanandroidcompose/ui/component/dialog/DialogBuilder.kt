package com.example.wanandroidcompose.ui.component.dialog

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun rememberWeDialogState(): DialogState {
    val state = remember { DialogStateImpl() }

    if (state.visible) {
        state.props?.let { props ->
            DefaultDialog(
                title = props.title,
                content = props.content,
                okText = props.okText,
                cancelText = props.cancelText,
                okColor = props.okColor,
                onOk = {
                    props.onOk?.invoke()
                    if (props.closeOnAction) {
                        state.hide()
                    }
                },
                onCancel = if (props.onCancel != null) {
                    {
                        props.onCancel.invoke()
                        if (props.closeOnAction) {
                            state.hide()
                        }
                    }
                } else null,
                onDismiss = {
                    state.hide()
                }
            )
        }
    }
    return state
}

@Composable
fun rememberMyDialogState(): MyDialogState {
    val state = remember { MyDialogStateImpl() }
    if (state.visible) {
        state.props?.let {
            MyDialog(
                onDismiss = {
                    state.hide()
                },
                dismissOnClickOutside = it.dismissOnClickOutside,
                content = it.content
            )
        }

    }
    return state
}

