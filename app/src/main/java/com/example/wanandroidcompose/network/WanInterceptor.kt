package com.example.wanandroidcompose.network

import com.example.wanandroidcompose.common.UserInfoUtils
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class WanInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()

        val token = UserInfoUtils.getUserToken()
        //给请求头携带上token
        val requestBuilder: Request.Builder = originalRequest.newBuilder()
            .header("Authorization", token)

        val newRequest: Request = requestBuilder.build()
        val response = chain.proceed(newRequest)

        //保存返回头携带的token
        response.header("X-Auth-Token").let {
            if (it.isNullOrBlank().not()) {
                UserInfoUtils.saveUserToken(it!!)
            }
        }


        return response
    }
}