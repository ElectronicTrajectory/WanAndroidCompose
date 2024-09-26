package com.example.wanandroidcompose.network

import com.example.wanandroidcompose.data.entity.resp.HomeArticleResp
import com.example.wanandroidcompose.data.entity.resp.LoginRegisterResp
import com.example.wanandroidcompose.data.entity.resp.QAResp
import com.example.wanandroidcompose.data.entity.resp.UserArticleResp
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    // 首页
    // 从0开始
    @GET("article/list/{page}/json")
    suspend fun getArticleList(@Path("page") page: Int): Response<BaseRespModel<HomeArticleResp>>

    // 从1开始,
    // 该接口支持传入 page_size 控制分页数量，取值为[1-40]，不传则使用默认值，一旦传入了 page_size，后续该接口分页都需要带上，否则会造成分页读取错误。
    @GET("wenda/list/{page}/json ")
    suspend fun getQaList(@Path("page") page: Int): Response<BaseRespModel<QAResp>>

    // 广场，获取用户的文章
    // 从0开始
    // 该接口支持传入 page_size 控制分页数量，取值为[1-40]，不传则使用默认值，一旦传入了 page_size，后续该接口分页都需要带上，否则会造成分页读取错误。
    @GET("user_article/list/{page}/json ")
    suspend fun getUserArticleList(@Path("page") page: Int): Response<BaseRespModel<UserArticleResp>>

    @POST("user/login")
    suspend fun login(@Query("username") username: String,@Query("password") password: String): Response<BaseRespModel<LoginRegisterResp>>

    @POST("user/register")
    suspend fun register(@Query("username") username: String,@Query("password") password: String,@Query("repassword") repassword: String): Response<BaseRespModel<LoginRegisterResp>>

}
