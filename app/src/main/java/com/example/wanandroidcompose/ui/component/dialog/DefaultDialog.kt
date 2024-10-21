package com.example.wanandroidcompose.ui.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.wanandroidcompose.ui.theme.AppTheme
import com.example.wanandroidcompose.ui.theme.Cancel

/**
 * 对话框
 *
 * @param title 标题
 * @param content 内容
 * @param okText 确定按钮文字
 * @param cancelText 取消按钮文字
 * @param okColor 确定按钮颜色
 * @param onOk 确定事件
 * @param onCancel 取消事件
 * @param onDismiss 关闭事件
 */
@Composable
fun DefaultDialog(
    title: String,
    content: String? = null,
    okText: String? = "确定",
    cancelText: String? = "取消",
    okColor: Color = Cancel,
    onOk: () -> Unit,
    onCancel: (() -> Unit)? = null,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .fillMaxWidth(0.8f)
                .background(MaterialTheme.colorScheme.onBackground)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 32.dp,
                            bottom = if (content != null) 16.dp else 0.dp,
                            start = 24.dp,
                            end = 24.dp
                        ),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                if (content != null) {
                    Text(
                        text = content,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        color = MaterialTheme.colorScheme.onSecondary,
                        fontSize = 17.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                HorizontalDivider(
                    Modifier,
                    thickness = 0.5.dp,
                    color = MaterialTheme.colorScheme.outline
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    if (onCancel != null && cancelText != null) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp)
                                .clickable(onClick = onCancel),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = cancelText,
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(0.5.dp, 56.dp)
                                .background(MaterialTheme.colorScheme.outline)
                        )
                    }
                    okText?.let {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp)
                                .clickable(onClick = onOk),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = okText,
                                color = okColor,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

            }
        }
    }
}

@PreviewLightDark
@Composable
private fun WeDialogPreview() {
    AppTheme {
        DefaultDialog(
            title = "标题",
            content = "正文",
            okText = "确认",
            onOk = {},
            cancelText = "取消",
            onCancel = {},
            onDismiss = {}
        )
    }
}