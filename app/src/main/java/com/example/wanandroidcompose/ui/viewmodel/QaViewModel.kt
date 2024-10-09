package com.example.wanandroidcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.wanandroidcompose.data.entity.resp.QAResp
import com.example.wanandroidcompose.data.paging.HomeArticlePagingSource
import com.example.wanandroidcompose.data.paging.QaPagingSource
import com.example.wanandroidcompose.data.repository.QaRepository
import com.example.wanandroidcompose.network.handleResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QaViewModel @Inject constructor(private val repo: QaRepository) : ViewModel() {
    val pager = Pager(PagingConfig(pageSize = 20)) {
        QaPagingSource(repo)
    }.flow.cachedIn(viewModelScope)
}