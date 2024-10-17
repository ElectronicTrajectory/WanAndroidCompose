package com.example.wanandroidcompose.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.wanandroidcompose.R
import com.example.wanandroidcompose.ui.activity.LocalInnerPadding
import com.example.wanandroidcompose.ui.component.common.EmptyScreen
import com.example.wanandroidcompose.ui.component.common.Toolbar

@Composable
fun RankScreen(navigate: (String) -> Unit, onBack: () -> Unit) {
    val padding = LocalInnerPadding.current
    Column(
        Modifier
            .fillMaxSize()
            .padding(bottom = padding.calculateBottomPadding())
    ) {
        Toolbar(
            modifier = Modifier.padding(top = padding.calculateTopPadding()),
            title = stringResource(id = R.string.mine_menu_rank),
            onBack = onBack
        )
        Box(modifier = Modifier){
            EmptyScreen()
            LazyColumn(Modifier.padding(horizontal = 12.dp)) {

            }
        }
    }
}