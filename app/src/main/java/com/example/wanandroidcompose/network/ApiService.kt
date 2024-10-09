package com.example.wanandroidcompose.network

import com.example.wanandroidcompose.data.entity.resp.CollectArticleResp
import com.example.wanandroidcompose.data.entity.resp.DetailUserInfo
import com.example.wanandroidcompose.data.entity.resp.HomeArticleResp
import com.example.wanandroidcompose.data.entity.resp.LoginRegisterResp
import com.example.wanandroidcompose.data.entity.resp.QAResp
import com.example.wanandroidcompose.data.entity.resp.SystemResp
import com.example.wanandroidcompose.data.entity.resp.UserArticleResp
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    /**
     * 首页
     * 从0开始
     */
    @GET("article/list/{page}/json")
    suspend fun getArticleList(@Path("page") page: Int): Response<BaseRespModel<HomeArticleResp>>

    /**
     * 从1开始,
     * 该接口支持传入 page_size 控制分页数量，取值为[1-40]，不传则使用默认值，一旦传入了 page_size，后续该接口分页都需要带上，否则会造成分页读取错误。
     */
    @GET("wenda/list/{page}/json")
    suspend fun getQaList(@Path("page") page: Int,@Query("page_size") pageSize: Int = 20): Response<BaseRespModel<QAResp>>

    /**
     * 广场，获取用户的文章
     * 从0开始
     * 该接口支持传入 page_size 控制分页数量，取值为[1-40]，不传则使用默认值20，一旦传入了 page_size，后续该接口分页都需要带上，否则会造成分页读取错误。
     */
    @GET("user_article/list/{page}/json")
    suspend fun getUserArticleList(@Path("page") page: Int,@Query("page_size") pageSize: Int = 20): Response<BaseRespModel<UserArticleResp>>

    @POST("user/login")
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): Response<BaseRespModel<LoginRegisterResp>>

    @POST("user/register")
    suspend fun register(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("repassword") repassword: String
    ): Response<BaseRespModel<LoginRegisterResp>>

    /**
     * 收藏文章列表
     * 方法：GET
     * 参数： 页码：拼接在链接中，从0开始。
     */
    @GET("lg/collect/list/{page}/json")
    suspend fun getCollectArticleList(@Path("page") page: Int): Response<BaseRespModel<CollectArticleResp>>

    /**
     * 获取自己分享的文章列表
     * page从1开始
     */
    @GET("user/lg/private_articles/{page}/json")
    suspend fun getMyShareArticleList(@Path("page") page: Int): Response<BaseRespModel<CollectArticleResp>>

    @GET("tree/json")
    suspend fun getSystem(): Response<BaseRespModel<SystemResp>>

    @GET("user/lg/userinfo/json")
    suspend fun getDetailUserInfo(): Response<BaseRespModel<DetailUserInfo>>
}
//
///**
// * 退出
// * 方法： GET
// * 访问了 logout 后，服务端会让客户端清除 Cookie（即cookie max-Age=0），
// * 如果客户端 Cookie 实现合理，可以实现自动清理，如果本地做了用户账号密码和保存，及时清理。
// */
//@GET("user/logout/json")
//suspend fun logout()
//
///**
// * 获取公众号列表
// * 方法： GET
// */
//@GET("wxarticle/chapters/json")
//suspend fun getWxArticleChapters();
//
///**
// * 查看某个公众号历史数据
// * 方法：GET
// * 参数：
// * 公众号 ID：拼接在 url 中，eg:405
// * 公众号页码：拼接在 url 中，eg:1
// */
//@GET("wxarticle/list/{id}/{page}/json")
//suspend fun  getWxArticleList(@Path("id") int id, @Path("page") int page);
//
///**
// * 在某个公众号中搜索历史文章
// * 方法：GET
// * 参数：
// * k : 字符串，eg:Java
// * 公众号 ID：拼接在 url 中，eg:405
// * 公众号页码：拼接在 url 中，eg:1
// */
//@GET("wxarticle/list/{id}/{page}/json")
//suspend fun getWxArticleList(@Path("id") int id,@Path("page") int page,@Query("k") String key);
//
///**
// * 项目分类
// * 方法： GET
// */
//@GET("project/tree/json")
//suspend fun getProjectChapters();
//
///**
// * 项目列表数据
// * 方法：GET
// * 参数：
// * cid 分类的id，上面项目分类接口
// * 页码：拼接在链接中，从1开始。
// */
//@GET("project/list/{page}/json")
//suspend fun getProjectArticleList(@Path("page") int page, @Query("cid") int id);
//
///**
// * 置顶文章
// * 方法：GET
// */
//@GET("article/top/json")
//suspend fun  getTopArticleList();
//
///**
// * 首页banner
// */
//@GET("banner/json")
//suspend fun  getBanner();
//
///**
// * 常用网站
// */
//@GET("friend/json")
//suspend fun  getUsefulWebList();
//
///**
// * 搜索热词
// */
//@GET("hotkey/json")
//suspend fun  getHotKeyList();
//
///**
// * 搜索
// * 方法：POST
// * 参数：
// * 页码：拼接在链接上，从0开始。
// * k ： 搜索关键词
// * 支持多个关键词，用空格隔开
// */
//@POST("article/query/{page}/json")
//suspend fun  search(@Path("page") int page, @Field("k") String key);
//
///**
// * 搜索热词
// */
//@GET("navi/json")
//suspend fun  getNaviList();
//
///**
// * 体系数据
// */
//@GET("tree/json")
//suspend fun  getKnowledgeList();
//
///**
// * 知识体系下的文章
// * 方法：GET
// * 参数：
// * cid 分类的id，上述二级目录的id
// * 页码：拼接在链接上，从0开始。
// */
//@GET("article/list/{page}/json")
//suspend fun  getChapterArticleList(@Path("page") int page, @Query("cid") int id, @Query("order_type") int orderType);
//

//
///**
// * 收藏网站列表
// * 方法：GET
// */
//@GET("lg/collect/usertools/json")
//suspend fun  getCollectLinkList();
//
///**
// * 收藏站内文章
// * 方法：POST
// * 参数： 文章id，拼接在链接中。
// */
//@POST("lg/collect/{id}/json")
//suspend fun collectArticle(@Path("id") int id);
//
///**
// * 收藏站外文章
// * 方法：POST
// * 参数：
// * title，author，link
// */
//@POST("lg/collect/add/json")
//suspend fun  collectArticle(@Field("title") String title, @Field("author") String author, @Field("link") String link);
//
///**
// * 收藏网址
// * 方法：POST
// * 参数：
// * name,link
// */
//@POST("lg/collect/addtool/json")
//suspend fun  collectLink(@Field("name") String name, @Field("link") String link);
//
///**
// * 取消收藏 文章列表
// * 方法：POST
// * 参数：
// * id:拼接在链接上 id传入的是列表中文章的id。
// */
//@POST("lg/uncollect_originId/{id}/json")
//suspend fun  uncollectArticle(@Path("id") int id);
//
///**
// * 删除收藏网站
// * 方法：POST
// * 参数：
// * id
// */
//@POST("lg/collect/deletetool/json")
//suspend fun  uncollectLink(@Field("id") int id);
//
///**
// * 取消收藏 我的收藏页面（该页面包含自己录入的内容）
// * 方法：POST
// * 参数：
// * id:拼接在链接上
// * originId:列表页下发，无则为-1
// * originId 代表的是你收藏之前的那篇文章本身的id； 但是收藏支持主动添加，这种情况下，没有originId则为-1
// */
//@POST("lg/uncollect/{id}/json")
//suspend fun uncollectArticle(@Path("id") int id,@Field("originId") int originId);
//
///**
// * 编辑收藏网站
// * 方法：POST
// * 参数：
// * id,name,link
// */
//@FormUrlEncoded
//@POST("lg/collect/updatetool/json")
//suspend fun updateCollectLink(@Field("id") int id, @Field("name") String name, @Field("link") String link);
//
///**
// * 获取个人积分
// */
//@GET("lg/coin/getcount/json")
//suspend fun getCoin();
//
///**
// * 获取个人积分
// */
//@GET("lg/coin/userinfo/json")
//suspend fun  getUserInfo();
//
///**
// * 未读消息数量
// */
//@GET("message/lg/count_unread/json")
//suspend fun getMessageUnreadCount();
//
///**
// * 未读消息列表
// */
//@GET("message/lg/unread_list/{page}/json")
//suspend fun getMessageUnreadList(@Path("page") int page);
//
///**
// * 已读消息列表
// */
//@GET("message/lg/readed_list/{page}/json")
//suspend fun  getMessageReadList(@Path("page") int page);
//
///**
// * 删除消息
// */
//@GET("/message/lg/delete/{id}")
//suspend fun  deleteMessage(@Path("id") int id);
//
///**
// * 获取个人积分获取列表
// * page 1开始
// */
//@GET("lg/coin/list/{page}/json")
//suspend fun  getCoinRecordList(@Path("page") int page);
//
///**
// * 积分排行榜接口
// * page 1开始
// */
//@GET("coin/rank/{page}/json")
//suspend fun  getCoinRankList(@Path("page") int page);
//
///**
// * 广场列表数据
// * 可能出现返回列表数据<每页数据，因为有自见的文章被过滤掉了。
// * page 0开始
// */
//@GET("user_article/list/{page}/json")
//suspend fun  getUserArticleList(@Path("page") int page);
//
///**
// * 分享人对应列表数据
// * page 从1开始
// */
//@GET("user/{userId}/share_articles/{page}/json")
//suspend fun getUserPage(@Path("userId") int userId,
//@Path("page") int page);
//
///**
// * 自己的分享的文章列表
// * 页码，从1开始
// */
//@GET("user/lg/private_articles/{page}/json")
//suspend fun  getMineShareArticleList(@Path("page") int page);
//
///**
// * 删除自己分享的文章
// * 文章id，拼接在链接上
// */
//@POST("lg/user_article/delete/{id}/json")
//suspend fun  deleteMineShareArticle(@Path("id") int id);
//
///**
// * 分享文章
// * 注意需要登录后查看，如果为CSDN，简书等链接会直接通过审核，在对外的分享文章列表中展示。
// * title
// * link
// */
//@POST("lg/user_article/add/json")
//suspend fun  shareArticle(@Field("title") String title, @Field("link") String link);
//
///**
// * 问答
// * pageId,拼接在链接上，例如上面的1
// */
//@GET("wenda/list/{page}/json")
//suspend fun getQuestionList(@Path("page") int page);
//
///**
// * 教程列表
// */
//@GET("chapter/547/sublist/json")
//suspend fun getBooks();