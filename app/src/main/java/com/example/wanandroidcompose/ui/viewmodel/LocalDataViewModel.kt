package com.example.wanandroidcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.wanandroidcompose.data.dao.ArticleDao
import com.example.wanandroidcompose.data.dao.ArticleEntity
import com.example.wanandroidcompose.data.paging.HistoryArticlePagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocalDataViewModel @Inject constructor(private val articleDao: ArticleDao) : ViewModel() {

    private val pageSize = 20

    fun insert(articleEntity: ArticleEntity) {
        viewModelScope.launch {
            articleDao.insert(articleEntity)
        }
    }

    val pager = Pager(
        PagingConfig(
            pageSize = pageSize,          // 每页的数据量
            prefetchDistance = 1,   // 当用户距离当前页底部还有 1 项时开始加载下一页
        ),
        pagingSourceFactory = { HistoryArticlePagingSource(articleDao,pageSize) }
    ).flow.cachedIn(viewModelScope)

}