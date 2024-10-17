package com.example.wanandroidcompose.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.rounded.ArrowUpward
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.wanandroidcompose.R
import com.example.wanandroidcompose.common.article2JsonForWebScreen
import com.example.wanandroidcompose.common.clickableWithoutRipple
import com.example.wanandroidcompose.ui.activity.LocalInnerPadding
import com.example.wanandroidcompose.ui.component.article.Article
import com.example.wanandroidcompose.ui.component.common.FloatButton
import com.example.wanandroidcompose.ui.component.common.Toolbar
import com.example.wanandroidcompose.ui.component.placeholder.HintView
import com.example.wanandroidcompose.ui.component.placeholder.HintViewState
import com.example.wanandroidcompose.ui.component.placeholder.LoadMore
import com.example.wanandroidcompose.ui.component.placeholder.LoadMoreState
import com.example.wanandroidcompose.ui.viewmodel.LocalDataViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HistoryScreen(navigate: (String) -> Unit, onBack: () -> Unit) {
    val viewmodel: LocalDataViewModel = hiltViewModel()
    val lazyPagingItems = viewmodel.pager.collectAsLazyPagingItems()
    val padding = LocalInnerPadding.current
    val coroutineScope = rememberCoroutineScope()
    val refreshing by remember {
        mutableStateOf(false)
    }
    val pullRefreshState = rememberPullRefreshState(refreshing, { lazyPagingItems.refresh() })
    val lazyListState = rememberLazyListState()
    Box(modifier = Modifier.fillMaxSize()) {
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
            Box(modifier = Modifier) {
                LazyColumn(
                    Modifier
                        .padding(horizontal = 12.dp)
                        .fillMaxSize()
                        .pullRefresh(pullRefreshState),
                    state = lazyListState
                ) {
                    items(lazyPagingItems.itemCount) { index ->
                        val item = lazyPagingItems[index]
                        item?.let {
                            val article = com.example.wanandroidcompose.data.model.Article(
                                item.author,
                                item.title,
                                item.time,
                                item.type,
                                item.link,
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
                    lazyPagingItems.apply {
                        when {
                            loadState.append is LoadState.Loading -> {
                                // 分页加载更多时的加载视图
                                item { LoadMore(LoadMoreState.LOADING) }
                            }

                            loadState.append is LoadState.Error -> {
                                // 加载更多时发生错误
                                item { LoadMore(LoadMoreState.FAIL) }
                            }
                        }
                    }
                }
                PullRefreshIndicator(// 指示器
                    refreshing, // 当前是否要刷新
                    pullRefreshState,
                    Modifier.align(Alignment.TopCenter)
                )
                if (lazyPagingItems.itemCount == 0) {
                    HintView(
                        Modifier.fillMaxSize(),
                        HintViewState.EMPTY
                    )
                }
                lazyPagingItems.apply {
                    when {
                        loadState.refresh is LoadState.Loading -> {
                            // 初次加载时的加载视图
                            HintView(
                                Modifier.fillMaxSize(),
                                HintViewState.LOADING
                            )
                        }

                        loadState.refresh is LoadState.Error -> {
                            // 错误视图
                            HintView(
                                Modifier
                                    .fillMaxSize()
                                    .clickableWithoutRipple {
                                        lazyPagingItems.refresh()
                                    },
                                HintViewState.FAIL
                            )
                        }

                    }
                }

            }
        }
        if (lazyListState.firstVisibleItemIndex != 0) {
            FloatButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clickableWithoutRipple {
                        coroutineScope.launch {
                            lazyListState.animateScrollToItem(0)
                        }
                    }
                    .padding(end = 12.dp, bottom = 12.dp),
                icon = Icons.Rounded.ArrowUpward,
                iconColor = MaterialTheme.colorScheme.onSecondary,
                bgColor = MaterialTheme.colorScheme.secondary
            )
        }
    }

}