package com.example.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("./robot/config/list")
    suspend fun getRobotConfig(): Response<BaseRespModel<ArrayList<String>>>
}
