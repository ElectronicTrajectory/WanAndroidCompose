package com.example.wanandroidcompose.ui.component.common

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun NetworkImage(modifier: Modifier, url: String, contentScale: ContentScale = ContentScale.Fit) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
//            .placeholder(R.mipmap.error)
//            .error(error)
            .build()
    )

    Image(
        painter = painter,
        contentDescription = "网络图片",
        modifier = modifier,
        contentScale = contentScale
    )
}