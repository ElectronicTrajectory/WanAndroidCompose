package com.example.wanandroidcompose.ui.component.common

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.wanandroidcompose.ui.viewmodel.WebViewViewModel


@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WanWebView(modifier: Modifier, url: String, webViewViewModel: WebViewViewModel) {

    AndroidView(modifier = modifier, factory = { context ->
        WebView(context).apply {
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true  // 启用 DOM 存储
                loadWithOverviewMode = true  // 适应屏幕大小
                useWideViewPort = true  // 启用广泛视图模式
            }

            webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    webViewViewModel.updateProgress(0)
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    webViewViewModel.clearProgress()
                }

                override fun onReceivedError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    error: WebResourceError?
                ) {
                    super.onReceivedError(view, request, error)
                    webViewViewModel.clearProgress()
                }
            }


            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)
                    webViewViewModel.updateProgress(newProgress)
                }
            }

            loadUrl(url)
        }
    })
}