package com.example.wanandroidcompose.network

import com.example.wanandroidcompose.common.UserInfoUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

class WanCookieJar: CookieJar {
    private val gson = Gson()

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        // 保存 Cookie 到 SharedPreferences
        val cookiesJson = gson.toJson(cookies)
        UserInfoUtils.saveUserCookie(cookiesJson)
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        // 从 SharedPreferences 加载 Cookie
        val cookiesJson = UserInfoUtils.getUserCookie()
        return if (cookiesJson.isNotBlank()) {
            val type = object : TypeToken<List<Cookie>>() {}.type
            gson.fromJson(cookiesJson, type)
        } else {
            emptyList()
        }
    }
}