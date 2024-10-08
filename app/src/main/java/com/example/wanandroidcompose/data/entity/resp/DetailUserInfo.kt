package com.example.wanandroidcompose.data.entity.resp

data class DetailUserInfo(
    val coinInfo: CoinInfo? = null,
    val collectArticleInfo: CollectArticleInfo? = null,
    val userInfo: UserInfo? = null
){
    data class CoinInfo(
        val coinCount: Int? = null,
        val level: Int? = null,
        val nickname: String? = null,
        val rank: String? = null,
        val userId: Int? = null,
        val username: String? = null
    )

    data class CollectArticleInfo(
        val count: Int? = null
    )

    data class UserInfo(
        val admin: Boolean? = null,
        val chapterTops: List<Any?>? = null,
        val coinCount: Int? = null,
        val collectIds: List<Int?>? = null,
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
}

