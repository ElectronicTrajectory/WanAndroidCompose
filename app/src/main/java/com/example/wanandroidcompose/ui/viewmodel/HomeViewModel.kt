package com.example.wanandroidcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.wanandroidcompose.data.paging.HomeArticlePagingSource
import com.example.wanandroidcompose.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: HomeRepository) : ViewModel() {
    val pager = Pager(PagingConfig(pageSize = 20)) {
        HomeArticlePagingSource(repo)
    }.flow.cachedIn(viewModelScope)

}