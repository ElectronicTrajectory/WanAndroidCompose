package com.example.wanandroidcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.wanandroidcompose.data.paging.PlayGroundPagingSource
import com.example.wanandroidcompose.data.repository.PlaygroundRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlaygroundViewModel @Inject constructor(private val repo: PlaygroundRepository) : ViewModel() {
    val pager = Pager(PagingConfig(pageSize = 20)) {
        PlayGroundPagingSource(repo)
    }.flow.cachedIn(viewModelScope)

}