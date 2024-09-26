package com.example.wanandroidcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wanandroidcompose.data.repository.UserRepository
import com.example.wanandroidcompose.network.handleResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repo: UserRepository) : ViewModel() {


    fun login(username: String, password: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            repo.login(username, password).collect {
                it.handleResult(
                    onSuccess = {
                        onSuccess()
                    }
                )
            }
        }
    }

    fun register(username: String, password: String, repassword: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            repo.register(username, password, repassword).collect {
                it.handleResult(
                    onSuccess = {
                        onSuccess()
                    }
                )
            }
        }
    }
}