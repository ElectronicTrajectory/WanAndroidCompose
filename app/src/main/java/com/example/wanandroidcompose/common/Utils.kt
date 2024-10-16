package com.example.wanandroidcompose.common

import android.net.Uri
import android.os.Bundle
import com.blankj.utilcode.util.GsonUtils
import com.example.wanandroidcompose.data.model.Article
import com.example.wanandroidcompose.ui.sealed.Screen


fun article2JsonForWebScreen(article: Article): String {
    val json = GsonUtils.toJson(article)
    val encodedPath = Uri.encode(json)
    val path = Screen.WebViewScreen.route.replace("{article}", encodedPath)
    return path
}

fun json2ArticleForWebScreen(bundle: Bundle?): Article? {
    val str = bundle?.getString("article")
    val decodedStr = Uri.decode(str)
    val article = try {
        GsonUtils.fromJson(decodedStr, Article::class.java)
    } catch (e: Exception) {
        null
    }
    return article
}