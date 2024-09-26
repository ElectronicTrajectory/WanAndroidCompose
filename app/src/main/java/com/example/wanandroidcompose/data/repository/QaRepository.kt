package com.example.wanandroidcompose.data.repository

import com.example.wanandroidcompose.network.ApiService
import com.example.wanandroidcompose.network.getResult
import com.example.wanandroidcompose.network.resultFlow
import javax.inject.Inject

class QaRepository @Inject constructor(private val api: ApiService) {
    suspend fun getQaList(page: Int) = resultFlow {
        getResult {
            api.getQaList(page)
        }
    }
}