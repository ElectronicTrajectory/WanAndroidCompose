package com.example.wanandroidcompose.ui.component.common

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
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
                blockNetworkImage = false
                domStorageEnabled = true  // 启用 DOM 存储
                loadWithOverviewMode = true  // 适应屏幕大小
                useWideViewPort = true  // 启用广泛视图模式
                settings.mixedContentMode =
                    WebSettings.MIXED_CONTENT_ALWAYS_ALLOW//webView从5.0后开始不允许混合模式，https中不可以加载http资源，需要设置开启
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