package com.example.wanandroidcompose.data.entity.resp

data class SystemResp(
    val articleList: List<Any?>? = null,
    val author: String? = null,
    val children: List<Children?>? = null,
    val courseId: Int? = null,
    val cover: String? = null,
    val desc: String? = null,
    val id: Int? = null,
    val lisense: String? = null,
    val lisenseLink: String? = null,
    val name: String? = null,
    val order: Int? = null,
    val parentChapterId: Int? = null,
    val type: Int? = null,
    val userControlSetTop: Boolean? = null,
    val visible: Int? = null
){
    data class Children(
        val articleList: List<Article?>? = null,
        val author: String? = null,
        val children: List<Any?>? = null,
        val courseId: Int? = null,
        val cover: String? = null,
        val desc: String? = null,
        val id: Int? = null,
        val lisense: String? = null,
        val lisenseLink: String? = null,
        val name: String? = null,
        val order: Int? = null,
        val parentChapterId: Int? = null,
        val type: Int? = null,
        val userControlSetTop: Boolean? = null,
        val visible: Int? = null
    ){
        data class Article(
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
            val tags: List<Any?>? = null,
            val title: String? = null,
            val type: Int? = null,
            val userId: Int? = null,
            val visible: Int? = null,
            val zan: Int? = null
        )
    }
}



