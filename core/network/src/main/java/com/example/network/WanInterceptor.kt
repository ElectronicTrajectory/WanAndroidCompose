package com.example.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class WanInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()

        val token = "UserInfoUtils.getUserToken()"
        //给请求头携带上token
        val requestBuilder: Request.Builder = originalRequest.newBuilder()
            .header("Authorization", token)

        val newRequest: Request = requestBuilder.build()
        val response = chain.proceed(newRequest)

        //保存返回头携带的token
        if (response.headers("X-Auth-Token").isNullOrEmpty().not()){
            response.header("X-Auth-Token")
        }

        return response
    }
}