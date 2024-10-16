package com.example.wanandroidcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.wanandroidcompose.data.dao.ArticleDao
import com.example.wanandroidcompose.data.dao.ArticleEntity
import com.example.wanandroidcompose.data.model.Article
import com.example.wanandroidcompose.data.paging.HistoryArticlePagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocalDataViewModel @Inject constructor(private val articleDao: ArticleDao) : ViewModel() {

    private val pageSize = 20

    fun check(article: Article) {
        viewModelScope.launch {
            val timeStamp = System.currentTimeMillis()
            if (articleDao.getArticleByLink(article.link) == null) {
                val articleEntity = ArticleEntity(
                    author = article.author,
                    title = article.title,
                    time = article.time,
                    type = article.type,
                    link = article.link,
                    lastReadTime = timeStamp
                )
                articleDao.insert(articleEntity)
            } else {
                articleDao.updateReadTime(article.link, timeStamp)
            }
        }
    }

    val pager = Pager(
        PagingConfig(
            pageSize = pageSize,          // 每页的数据量
            prefetchDistance = 1,   // 当用户距离当前页底部还有 1 项时开始加载下一页
        ),
        pagingSourceFactory = { HistoryArticlePagingSource(articleDao, pageSize) }
    ).flow.cachedIn(viewModelScope)

}