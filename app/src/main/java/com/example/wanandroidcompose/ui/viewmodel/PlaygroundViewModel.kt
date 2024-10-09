package com.example.wanandroidcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.wanandroidcompose.data.entity.resp.UserArticleResp
import com.example.wanandroidcompose.data.paging.HomeArticlePagingSource
import com.example.wanandroidcompose.data.paging.PlayGroundPagingSource
import com.example.wanandroidcompose.data.repository.PlaygroundRepository
import com.example.wanandroidcompose.network.handleResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaygroundViewModel @Inject constructor(private val repo: PlaygroundRepository) : ViewModel() {
    val pager = Pager(PagingConfig(pageSize = 20)) {
        PlayGroundPagingSource(repo)
    }.flow.cachedIn(viewModelScope)



//    private val _data = MutableStateFlow<UserArticleResp?>(null)
//    val data = _data.asStateFlow()
//
//    fun getArticleList(page: Int){
//        viewModelScope.launch {
//            repo.getUserArticleList(page).collect{
//                it.handleResult(
//                    onSuccess = { resp->
//                        _data.update { resp }
//                    }
//                )
//            }
//        }
//    }

}