package com.example.wanandroidcompose.ui.screen

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.JsonUtils
import com.example.wanandroidcompose.R
import com.example.wanandroidcompose.common.article2JsonForWebScreen
import com.example.wanandroidcompose.ui.activity.LocalInnerPadding
import com.example.wanandroidcompose.ui.component.article.Article
import com.example.wanandroidcompose.ui.component.common.Toolbar
import com.example.wanandroidcompose.ui.sealed.Screen
import com.example.wanandroidcompose.ui.viewmodel.LocalDataViewModel

@Composable
fun HistoryScreen(navigate: (String) -> Unit, onBack: () -> Unit) {
    val viewmodel: LocalDataViewModel = hiltViewModel()
    val lazyPagingItems = viewmodel.pager.collectAsLazyPagingItems()
    val padding = LocalInnerPadding.current
    Column(
        Modifier
            .fillMaxSize()
            .padding(bottom = padding.calculateBottomPadding())
    ) {
        Toolbar(
            modifier = Modifier.padding(top = padding.calculateTopPadding()),
            title = stringResource(id = R.string.mine_menu_history),
            onBack = onBack
        )
        LazyColumn(Modifier.padding(horizontal = 12.dp)) {
            items(lazyPagingItems.itemCount) { index ->
                val item = lazyPagingItems[index]
                item?.let {
                    val article = com.example.wanandroidcompose.data.model.Article(
                        item.author,
                        item.title,
                        item.time,
                        item.type,
                        item.link
                    )
                    if (index == 0) {
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                    Article(
                        modifier = Modifier.clickable {
                            navigate(article2JsonForWebScreen(article))
                        },
                        article = article
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}