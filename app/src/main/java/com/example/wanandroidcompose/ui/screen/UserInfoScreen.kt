package com.example.wanandroidcompose.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.wanandroidcompose.R
import com.example.wanandroidcompose.common.MikuImageLink
import com.example.wanandroidcompose.common.toast
import com.example.wanandroidcompose.ui.activity.LocalInnerPadding
import com.example.wanandroidcompose.ui.component.common.BarButton
import com.example.wanandroidcompose.ui.component.common.KeyValueItem
import com.example.wanandroidcompose.ui.component.common.NetworkImage
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentAlignment = Alignment.Center
        ) {
            NetworkImage(
                url = MikuImageLink,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )
        }
        val modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 12.dp)

        LazyColumn {
            item {  KeyValueItem(modifier, stringResource(id = R.string.user_name),userInfo?.userInfo?.username.toString()) }
            item {  KeyValueItem(modifier, stringResource(id = R.string.user_email),userInfo?.userInfo?.email.toString()) }
            item {  KeyValueItem(modifier, stringResource(id = R.string.user_rank),userInfo?.coinInfo?.rank.toString()) }
            item {  KeyValueItem(modifier, stringResource(id = R.string.user_level),userInfo?.coinInfo?.level.toString()) }
            item {  KeyValueItem(modifier, stringResource(id = R.string.user_coin),userInfo?.coinInfo?.coinCount.toString()) }
            item { Spacer(modifier = Modifier.height(12.dp)) }
            item {
                BarButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .height(48.dp),
                    title = stringResource(id = R.string.logout),
                    textColor = MaterialTheme.colorScheme.onSecondary,
                    bgColor = MaterialTheme.colorScheme.secondary
                ) {

                }
            }
        }


    }
}