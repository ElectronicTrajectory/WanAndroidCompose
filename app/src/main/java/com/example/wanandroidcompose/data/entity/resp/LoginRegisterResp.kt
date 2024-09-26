package com.example.wanandroidcompose.data.entity.resp

//登录注册的数据
data class LoginRegisterResp(
    val admin: Boolean? = null,
    val chapterTops: List<Any?>? = null,
    val coinCount: Int? = null,
    val collectIds: List<Any?>? = null,
    val email: String? = null,
    val icon: String? = null,
    val id: Int? = null,
    val nickname: String? = null,
    val password: String? = null,
    val publicName: String? = null,
    val token: String? = null,
    val type: Int? = null,
    val username: String? = null
)