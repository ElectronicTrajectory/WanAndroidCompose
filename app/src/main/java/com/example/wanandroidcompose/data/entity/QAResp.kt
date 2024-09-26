package com.example.wanandroidcompose.data.entity

import com.example.wanandroidcompose.data.model.Article

data class QAResp(
    val curPage: Int? = 0,
    val datas: List<Data>? = listOf(),
    val offset: Int? = 0,
    val over: Boolean? = false,
    val pageCount: Int? = 0,
    val size: Int? = 0,
    val total: Int? = 0
){
    data class Data(
        val adminAdd: Boolean? = null,
        val apkLink: String? = null,
        val audit: Int? = null,
        val author: String? = null,
        val canEdit: Boolean? = null,
        val chapterId: Int? = null,
        val chapterName: String? = null,
        val collect: Boolean? = null,
        val courseId: Int? = null,
        val desc: String? = null,
        val descMd: String? = null,
        val envelopePic: String? = null,
        val fresh: Boolean? = null,
        val host: String? = null,
        val id: Int? = null,
        val isAdminAdd: Boolean? = null,
        val link: String? = null,
        val niceDate: String? = null,
        val niceShareDate: String? = null,
        val origin: String? = null,
        val prefix: String? = null,
        val projectLink: String? = null,
        val publishTime: Long? = null,
        val realSuperChapterId: Int? = null,
        val selfVisible: Int? = null,
        val shareDate: Long? = null,
        val shareUser: String? = null,
        val superChapterId: Int? = null,
        val superChapterName: String? = null,
        val tags: List<QaTag?>? = null,
        val title: String? = null,
        val type: Int? = null,
        val userId: Int? = null,
        val visible: Int? = null,
        val zan: Int? = null
    )

    data class QaTag(
        val name: String? = null,
        val url: String? = null
    )
}

fun QAResp.Data.asArticle(): Article {
    var author = ""
    if (this.shareUser.isNullOrBlank().not()){
        author = this.shareUser!!
    }
    if (this.author.isNullOrBlank().not()){
        author = this.author!!
    }
    return Article(
        author,
        this.title?:"",
        this.niceDate?:"",
        this.superChapterName?:""
    )
}