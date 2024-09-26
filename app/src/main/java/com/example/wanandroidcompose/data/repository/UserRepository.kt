package com.example.wanandroidcompose.data.repository

import com.example.wanandroidcompose.network.ApiService
import com.example.wanandroidcompose.network.getResult
import com.example.wanandroidcompose.network.resultFlow
import retrofit2.http.Query
import javax.inject.Inject

class UserRepository @Inject constructor(private val api: ApiService) {
    suspend fun login(username: String, password: String) = resultFlow {
        getResult {
            api.login(username, password)
        }
    }

    suspend fun register(username: String, password: String, repassword: String) = resultFlow {
        getResult {
            api.register(username, password, repassword)
        }
    }
}