package com.example.wanandroidcompose.common

import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.SPUtils
import com.example.wanandroidcompose.data.entity.resp.LoginRegisterResp

object UserInfoUtils {
    private const val TAG = "userInfo"
    private const val USER_NAME = "userName"
    private const val USER_ID = "userId"
    private const val USER_AVATAR = "userAvatar"
    private const val USER_COOKIE = "userCookie"
    private const val LOGIN_INFO = "loginInfo"


    fun clearInfo() {
        SPUtils.getInstance(TAG).clear()
    }

    fun saveUserName(string: String) {
        SPUtils.getInstance(TAG).put(USER_NAME, string)
    }

    fun getUserName(): String {
        return SPUtils.getInstance(TAG).getString(USER_NAME)
    }


    fun saveUserID(int: Int) {
        SPUtils.getInstance(TAG).put(USER_ID, int)

    }

    fun getUserId(): String {
        return SPUtils.getInstance(TAG).getString(USER_ID)
    }

    fun saveUserAvatar(string: String) {
        SPUtils.getInstance(TAG).put(USER_AVATAR, string)

    }

    fun getUserAvatar(): String {
        return SPUtils.getInstance(TAG).getString(USER_AVATAR)
    }

    fun saveUserCookie(cookie: String) {
        SPUtils.getInstance(TAG).put(USER_COOKIE, cookie)
    }

    fun getUserCookie(): String {
        return SPUtils.getInstance(TAG).getString(USER_COOKIE)
    }

    fun saveLoginInfo(string: String) {
        SPUtils.getInstance(TAG).put(LOGIN_INFO, string)
    }

    fun getLoginInfo(): LoginRegisterResp? {
        val data = SPUtils.getInstance(TAG).getString(LOGIN_INFO)
        return try {
            GsonUtils.fromJson(data, LoginRegisterResp::class.java)
        } catch (e: Exception) {
            null
        }
    }
}