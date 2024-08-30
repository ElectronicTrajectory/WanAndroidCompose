package com.example.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object WanRetrofit{
    private const val BASE_URL = "https://www.wanandroid.com/"

    private val client:OkHttpClient by lazy {
        OkHttpClient.Builder().addInterceptor(WanInterceptor()).build()
    }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> createService(service: Class<T>): T {
        return retrofit.create(service)
    }

}