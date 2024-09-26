package com.example.wanandroidcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wanandroidcompose.data.entity.resp.HomeArticleResp
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
    private val _data = MutableStateFlow<HomeArticleResp?>(null)
    val data = _data.asStateFlow()

    fun getArticleList(page: Int){
        viewModelScope.launch {
            repo.getArticleList(page).collect{
                it.handleResult(
                    onSuccess = { resp->
                        _data.update { resp }
                    }
                )
            }
        }
    }

}