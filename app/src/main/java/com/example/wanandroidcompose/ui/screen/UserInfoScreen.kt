package com.example.wanandroidcompose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.wanandroidcompose.R
import com.example.wanandroidcompose.ui.activity.LocalInnerPadding
import com.example.wanandroidcompose.ui.component.common.Toolbar
import com.example.wanandroidcompose.ui.viewmodel.UserViewModel

@Composable
fun UserInfoScreen(navigate: (String) -> Unit, onBack: () -> Unit) {
    val padding = LocalInnerPadding.current
    val viewmodel: UserViewModel = hiltViewModel()
    val userInfo by viewmodel.detailUserInfo.collectAsState()
    LaunchedEffect(Unit) {
        viewmodel.getDetailUserInfo()
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(bottom = padding.calculateBottomPadding())
    ) {
        Toolbar(
            modifier = Modifier.padding(top = padding.calculateTopPadding()),
            title = stringResource(id = R.string.mine_user_info),
            onBack = onBack
        )
        Text(text = userInfo?.userInfo?.username?:"")
        Text(text = userInfo?.coinInfo?.coinCount.toString())
        Text(text = userInfo?.coinInfo?.level.toString())
    }
}