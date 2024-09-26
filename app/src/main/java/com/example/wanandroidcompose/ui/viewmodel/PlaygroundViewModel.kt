package com.example.wanandroidcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wanandroidcompose.data.entity.HomeArticleResp
import com.example.wanandroidcompose.data.entity.UserArticleResp
import com.example.wanandroidcompose.data.repository.HomeRepository
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
    private val _data = MutableStateFlow<UserArticleResp?>(null)
    val data = _data.asStateFlow()

    fun getArticleList(page: Int){
        viewModelScope.launch {
            repo.getUserArticleList(page).collect{
                it.handleResult(
                    onSuccess = { resp->
                        _data.update { resp }
                    }
                )
            }
        }
    }

}