package com.example.wanandroidcompose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.wanandroidcompose.data.model.Article
import com.example.wanandroidcompose.ui.activity.LocalInnerPadding
import com.example.wanandroidcompose.ui.component.common.FloatButtonWithProgress
import com.example.wanandroidcompose.ui.component.common.WanWebView
import com.example.wanandroidcompose.ui.viewmodel.LocalDataViewModel
import com.example.wanandroidcompose.ui.viewmodel.WebViewViewModel

@Composable
fun WebViewScreen(article: Article, onBack: () -> Unit) {

    val localDataViewModel: LocalDataViewModel = hiltViewModel()
    val webViewViewModel: WebViewViewModel = hiltViewModel()
    val padding = LocalInnerPadding.current

    val progress by webViewViewModel.loadProgress.collectAsState()
    LaunchedEffect(Unit) {
        localDataViewModel.check(article)
    }
    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(padding.calculateTopPadding()))
            WanWebView(modifier = Modifier.fillMaxSize(), url = article.link, webViewViewModel)
        }

        FloatButtonWithProgress(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 12.dp, bottom = 12.dp)
                .clickable { onBack() },
            icon = Icons.Rounded.ArrowBackIosNew,
            iconColor = MaterialTheme.colorScheme.onSecondary,
            bgColor =  MaterialTheme.colorScheme.secondary,
            progressColor = MaterialTheme.colorScheme.onSecondary,
            strokeWidth = 4.dp,
            progress = progress?.times(0.01F)
        )
    }
}