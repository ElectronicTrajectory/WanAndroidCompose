package com.example.wanandroidcompose.ui.component.common

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wanandroidcompose.common.clickableWithoutRipple


@SuppressLint("UnrememberedMutableState")
@Composable
fun WanInput(
    modifier: Modifier = Modifier,
    value: String = "",
    placeholder: String? = null,
    disabled: Boolean = false,
    textAlign: TextAlign = TextAlign.Unspecified,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onClick: (() -> Unit)? = null,
    onChange: ((String) -> Unit)? = null
) {
    val height = 56.dp
    var hidePassword by remember {
        mutableStateOf(true)
    }
    val isPassword = keyboardOptions.keyboardType == KeyboardType.Password

    val visualTransformation by derivedStateOf {
        if (hidePassword && isPassword) PasswordVisualTransformation() else VisualTransformation.None
    }
    Row(
        modifier = modifier
            .height(height)
            .background(MaterialTheme.colorScheme.surfaceContainer, RoundedCornerShape(height / 2)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            value = value,
            onValueChange = {
                onChange?.invoke(it.replace(" ", ""))
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(height),
            readOnly = disabled,
            singleLine = true,
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 16.sp,
                textAlign = textAlign
            ),
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            visualTransformation = visualTransformation,
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurfaceVariant)
        ) { innerTextField ->
            Row(
                Modifier.padding(horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(1F)
                        .then(onClick?.let {
                            Modifier.clickableWithoutRipple { it() }
                        } ?: Modifier),
                    contentAlignment = when (textAlign) {
                        TextAlign.Center -> Alignment.Center
                        TextAlign.Right -> Alignment.CenterEnd
                        else -> Alignment.CenterStart
                    }
                ) {
                    innerTextField()
                    if (value.isEmpty() && placeholder?.isNotEmpty() == true) {
                        Text(
                            text = placeholder,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 16.sp
                        )
                    }
                }
                if (isPassword) {
                    Spacer(modifier = Modifier.width(12.dp))
                    Icon(
                        imageVector = if (hidePassword) Icons.Rounded.VisibilityOff else Icons.Rounded.Visibility,
                        contentDescription = "",
                        Modifier.clickableWithoutRipple { hidePassword = !hidePassword },
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }

            }

        }
    }
}
