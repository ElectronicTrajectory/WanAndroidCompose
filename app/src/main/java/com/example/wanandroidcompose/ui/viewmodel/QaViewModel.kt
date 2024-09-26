package com.example.wanandroidcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wanandroidcompose.data.entity.HomeArticleResp
import com.example.wanandroidcompose.data.entity.QAResp
import com.example.wanandroidcompose.data.repository.HomeRepository
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
    private val _data = MutableStateFlow<QAResp?>(null)
    val data = _data.asStateFlow()

    fun getArticleList(page: Int){
        viewModelScope.launch {
            repo.getQaList(page).collect{
                it.handleResult(
                    onSuccess = { resp->
                        _data.update { resp }
                    }
                )
            }
        }
    }

}