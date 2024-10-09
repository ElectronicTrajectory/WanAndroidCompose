package com.example.wanandroidcompose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.wanandroidcompose.data.entity.resp.asArticle
import com.example.wanandroidcompose.ui.activity.LocalInnerPadding
import com.example.wanandroidcompose.ui.component.article.Article
import com.example.wanandroidcompose.ui.component.placeholder.HintView
import com.example.wanandroidcompose.ui.component.placeholder.LoadMore
import com.example.wanandroidcompose.ui.viewmodel.QaViewModel

@Composable
fun QAScreen(navigate:(String)->Unit){
    val viewmodel: QaViewModel = hiltViewModel()
    val padding = LocalInnerPadding.current
    val lazyPagingItems = viewmodel.pager.collectAsLazyPagingItems()

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = padding.calculateTopPadding(), bottom = padding.calculateBottomPadding())
    ) {
        lazyPagingItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    // 初次加载时的加载视图
                    HintView(Modifier.fillMaxSize(), Icons.Default.Error,"载入中")
                }
                loadState.refresh is LoadState.Error -> {
                    // 错误视图
                    HintView(Modifier.fillMaxSize(), Icons.Default.Error,"暂无内容")
                }

            }
        }

        LazyColumn(Modifier.padding(horizontal = 12.dp)) {
            items(lazyPagingItems.itemCount) { index ->
                val item = lazyPagingItems[index]
                item?.let {
                    Article(modifier = Modifier, article = item.asArticle())
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
            lazyPagingItems.apply {
                when {
                    loadState.append is LoadState.Loading -> {
                        // 分页加载更多时的加载视图
                        item { LoadMore("加载更多") }
                    }
                    loadState.append is LoadState.Error -> {
                        // 加载更多时发生错误
                        item { LoadMore("加载失败") }
                    }
                }
            }
        }
    }
}