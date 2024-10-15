package com.example.wanandroidcompose.data.repository

import com.example.wanandroidcompose.network.ApiService
import com.example.wanandroidcompose.network.getResult
import com.example.wanandroidcompose.network.resultFlow
import javax.inject.Inject

class OtherRepository @Inject constructor(private val api: ApiService) {
    suspend fun getArticleList(page: Int) = resultFlow {
        getResult {
            api.getCollectArticleList(page)
        }
    }
}