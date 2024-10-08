package com.example.wanandroidcompose.network

import com.example.wanandroidcompose.common.UserInfoUtils
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class WanInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val requestBuilder: Request.Builder = originalRequest.newBuilder()
        val newRequest: Request = requestBuilder.build()
        val response = chain.proceed(newRequest)
        return response
    }
}