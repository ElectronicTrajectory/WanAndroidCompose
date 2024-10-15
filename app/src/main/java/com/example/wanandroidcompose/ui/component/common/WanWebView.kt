package com.example.wanandroidcompose.ui.component.common

import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WanWebView(modifier: Modifier, url: String) {

    AndroidView(modifier = modifier, factory = { context ->
        WebView(context).apply {
            webViewClient = WebViewClient()

            settings.javaScriptEnabled = true
            val client = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)
                }
            }


            loadUrl(url)
        }
    })
}