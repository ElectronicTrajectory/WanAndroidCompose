package com.example.wanandroidcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.GsonUtils
import com.example.wanandroidcompose.common.UserInfoUtils
import com.example.wanandroidcompose.data.entity.resp.DetailUserInfo
import com.example.wanandroidcompose.data.entity.resp.LoginRegisterResp
import com.example.wanandroidcompose.data.repository.UserRepository
import com.example.wanandroidcompose.network.handleResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repo: UserRepository) : ViewModel() {
    private var _detailUserInfo = MutableStateFlow<DetailUserInfo?>(null)
    val detailUserInfo = _detailUserInfo.asStateFlow()


    fun login(username: String, password: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            repo.login(username, password).collect {
                it.handleResult(
                    onSuccess = { resp ->
                        resp?.let {
                            saveUserInfo(resp)
                            onSuccess()
                        }
                    }
                )
            }
        }
    }

    fun register(username: String, password: String, repassword: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            repo.register(username, password, repassword).collect {
                it.handleResult(
                    onSuccess = { resp ->
                        resp?.let {
                            saveUserInfo(resp)
                            onSuccess()
                        }
                    }
                )
            }
        }
    }

    fun getDetailUserInfo() {
        viewModelScope.launch {
            repo.getDetailUserInfo().collect {
                it.handleResult(
                    onSuccess = { resp ->
                        _detailUserInfo.update {
                            resp
                        }
                    }
                )
            }
        }
    }

    private fun saveUserInfo(data: LoginRegisterResp) {
        UserInfoUtils.saveLoginInfo(GsonUtils.toJson(data))
    }
}