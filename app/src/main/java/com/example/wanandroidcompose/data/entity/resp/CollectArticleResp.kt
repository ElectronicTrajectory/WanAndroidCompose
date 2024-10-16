package com.example.wanandroidcompose.data.entity.resp

import com.example.wanandroidcompose.data.model.Article


data class CollectArticleResp(
    val curPage: Int? = 0,
    val datas: List<Data>? = listOf(),
    val offset: Int? = 0,
    val over: Boolean? = false,
    val pageCount: Int? = 0,
    val size: Int? = 0,
    val total: Int? = 0
) {
    data class Data(
        val author: String? = null,
        val chapterId: Int? = null,
        val chapterName: String? = null,
        val courseId: Int? = null,
        val desc: String? = null,
        val envelopePic: String? = null,
        val id: Int? = null,
        val link: String? = null,
        val niceDate: String? = null,
        val origin: String? = null,
        val originId: Int? = null,
        val publishTime: Long? = null,
        val title: String? = null,
        val userId: Int? = null,
        val visible: Int? = null,
        val zan: Int? = null
    )
}
fun CollectArticleResp.Data.asArticle(): Article {
    return Article(
        this.author?:"",
        this.title?:"",
        this.niceDate?:"",
        this.chapterName?:"",
        this.link?:""
    )
}

