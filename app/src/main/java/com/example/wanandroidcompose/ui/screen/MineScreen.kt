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
import com.example.wanandroidcompose.common.clickableWithoutRipple
import com.example.wanandroidcompose.common.mineMenuItems
import com.example.wanandroidcompose.common.toast
import com.example.wanandroidcompose.ui.activity.LocalInnerPadding
import com.example.wanandroidcompose.ui.component.common.MenuItem
import com.example.wanandroidcompose.ui.component.common.UserInfoCard
import com.example.wanandroidcompose.ui.sealed.Screen

@Composable
fun MineScreen(navigate: (String) -> Unit) {
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
                .clickableWithoutRipple { navigate(Screen.LoginScreen.route) }
                .padding(horizontal = 12.dp),
            "https://ts2.cn.mm.bing.net/th?id=OIP.2sI-q7UlIi6zLgWLjLYS6AHaHa",
            "Hatsune Miku",
            "miku@gmail.com")
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