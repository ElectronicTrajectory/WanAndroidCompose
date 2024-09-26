package com.example.wanandroidcompose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.wanandroidcompose.R
import com.example.wanandroidcompose.ui.component.common.BarButton
import com.example.wanandroidcompose.ui.component.common.WanInput
import com.example.wanandroidcompose.ui.viewmodel.UserViewModel

@Composable
fun LoginScreen(onBack: () -> Unit) {
    var account by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val viewmodel: UserViewModel = hiltViewModel()

    val loginBtnHeight = 56.dp

    Surface {
        Column(
            Modifier
                .padding(horizontal = 24.dp)
                .systemBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(48.dp))

            WanInput(
                value = account,
                onChange = { account = it },
                placeholder = stringResource(id = R.string.login_input_account),
            )
            Spacer(modifier = Modifier.height(12.dp))
            WanInput(
                value = password,
                onChange = { password = it },
                placeholder = stringResource(id = R.string.login_input_password),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(36.dp))

            BarButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(loginBtnHeight)
                    .clip(RoundedCornerShape(loginBtnHeight * 0.5F)),
                title = stringResource(id = R.string.login),
                textColor = MaterialTheme.colorScheme.onPrimaryContainer,
                bgColor = MaterialTheme.colorScheme.primaryContainer,
                fontSize = 18.sp
            ) {

                viewmodel.login(account, password) {
                    onBack()
                }
            }
        }
    }

}