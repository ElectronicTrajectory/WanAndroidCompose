package com.example.wanandroidcompose.ui.screen

import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.wanandroidcompose.data.entity.asArticle
import com.example.wanandroidcompose.ui.activity.LocalInnerPadding
import com.example.wanandroidcompose.ui.component.article.Article
import com.example.wanandroidcompose.ui.viewmodel.PlaygroundViewModel

@Composable
fun PlaygroundScreen(navigate:(String)->Unit){
    val viewmodel: PlaygroundViewModel = hiltViewModel()
    val data by viewmodel.data.collectAsState()
    val padding = LocalInnerPadding.current
    LaunchedEffect(Unit) {
        viewmodel.getArticleList(0)
    }
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = padding.calculateTopPadding(), bottom = padding.calculateBottomPadding())
    ) {

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