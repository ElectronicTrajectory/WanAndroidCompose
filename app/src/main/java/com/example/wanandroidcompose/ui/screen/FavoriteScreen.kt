package com.example.wanandroidcompose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.wanandroidcompose.R
import com.example.wanandroidcompose.data.entity.resp.asArticle
import com.example.wanandroidcompose.ui.activity.LocalInnerPadding
import com.example.wanandroidcompose.ui.component.article.Article
import com.example.wanandroidcompose.ui.component.common.Toolbar
import com.example.wanandroidcompose.ui.viewmodel.CollectArticleViewModel

@Composable
fun FavoriteScreen(navigate: (String) -> Unit, onBack: () -> Unit) {
    val viewmodel: CollectArticleViewModel = hiltViewModel()
    val data by viewmodel.data.collectAsState()
    val padding = LocalInnerPadding.current
    LaunchedEffect(Unit) {
        viewmodel.getArticleList(0)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(bottom = padding.calculateBottomPadding())
    ) {
        Toolbar(modifier = Modifier.padding(top = padding.calculateTopPadding()), title = stringResource(id = R.string.mine_menu_favorite), onBack = onBack)
        LazyColumn(Modifier.padding(horizontal = 12.dp)) {
            itemsIndexed(data?.datas ?: emptyList()) { index, article ->
                if (index == 0) {
                    Spacer(modifier = Modifier.height(12.dp))
                }
                Article(modifier = Modifier, article = article.asArticle())
                Spacer(modifier = Modifier.height(12.dp))

            }
        }
    }
}