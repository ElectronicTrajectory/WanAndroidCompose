package com.example.wanandroidcompose.ui.component.common

import android.os.Build
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature

@Composable
fun WanWebView(modifier: Modifier,url: String) {

    AndroidView(modifier = modifier,factory = { context ->
        WebView(context).apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(url)
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//                if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
//                    // 支持暗色模式特性
//                    WebSettingsCompat.setForceDark(this.settings,WebSettings.FORCE_DARK_ON)
//                }
//            } else {
//                // 对于较低版本，可以考虑手动设置背景色
//                setBackgroundColor(0xFF121212.toInt()) // 设置背景为暗色
//            }
        }
    })
}