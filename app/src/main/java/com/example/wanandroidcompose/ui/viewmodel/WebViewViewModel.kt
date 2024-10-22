package com.example.wanandroidcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WebViewViewModel @Inject constructor() : ViewModel() {
    private val _loadProgress = MutableStateFlow<Int?>(null)
    val loadProgress = _loadProgress.asStateFlow()

    fun updateProgress(newProgress: Int?) {
        _loadProgress.update {
            newProgress
        }
    }
    fun clearProgress(){
        viewModelScope.launch {
            delay(800)
            updateProgress(null)
        }
    }

}