package com.example.wanandroidcompose.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.wanandroidcompose.R
import com.example.wanandroidcompose.common.UserInfoUtils
import com.example.wanandroidcompose.common.clickableWithoutRipple
import com.example.wanandroidcompose.common.MikuImageLink
import com.example.wanandroidcompose.common.mineMenuItems
import com.example.wanandroidcompose.ui.activity.LocalInnerPadding
import com.example.wanandroidcompose.ui.component.common.MenuItem
import com.example.wanandroidcompose.ui.component.common.UserInfoCard
import com.example.wanandroidcompose.ui.sealed.Screen

@Composable
fun MineScreen(navigate: (String) -> Unit) {
    val userInfo = UserInfoUtils.getLoginInfo()
    val padding = LocalInnerPadding.current
    Column(
        modifier = Modifier.padding(
            top = padding.calculateTopPadding(),
            bottom = padding.calculateBottomPadding()
        )
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        UserInfoCard(
            Modifier
                .clickableWithoutRipple {
                    if (UserInfoUtils.getLoginInfo()!=null){
                        navigate(Screen.UserInfoScreen.route)
                    }else{
                        navigate(Screen.LoginScreen.route)
                    }
                }
                .padding(horizontal = 12.dp),
            MikuImageLink,
            userInfo?.username?: stringResource(id = R.string.please_login),
            userInfo?.email?:"")
        Spacer(modifier = Modifier.height(36.dp))
        LazyColumn(
            Modifier
                .weight(1F)
                .fillMaxWidth()
        ) {
            items(mineMenuItems) { item ->
                MenuItem(Modifier.clickable {
                    navigate(item.route)
                }, item.leadingIcon, stringResource(id = item.title), item.trailingIcon)
            }
        }
    }
}