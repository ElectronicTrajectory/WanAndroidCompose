package com.example.wanandroidcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.wanandroidcompose.data.entity.resp.HomeArticleResp
import com.example.wanandroidcompose.data.paging.MyPagingSource
import com.example.wanandroidcompose.data.repository.HomeRepository
import com.example.wanandroidcompose.network.handleResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: HomeRepository) : ViewModel() {
    val pager = Pager(PagingConfig(pageSize = 20)) {
        MyPagingSource(repo)
    }.flow.cachedIn(viewModelScope)

}