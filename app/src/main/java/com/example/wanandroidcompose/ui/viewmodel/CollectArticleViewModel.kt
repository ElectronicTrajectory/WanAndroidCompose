package com.example.wanandroidcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.wanandroidcompose.data.paging.CollectedArticlePagingSource
import com.example.wanandroidcompose.data.repository.OtherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CollectArticleViewModel @Inject constructor(private val repo: OtherRepository)  : ViewModel() {
    val pager = Pager(
        PagingConfig(
            pageSize = 20,          // 每页的数据量
            prefetchDistance = 1,   // 当用户距离当前页底部还有 1 项时开始加载下一页
        ),
        pagingSourceFactory = { CollectedArticlePagingSource(repo) }
    ).flow.cachedIn(viewModelScope)

}