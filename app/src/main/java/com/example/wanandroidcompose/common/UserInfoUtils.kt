package com.example.wanandroidcompose.common

import com.blankj.utilcode.util.SPUtils

object UserInfoUtils {
    private const val TAG = "userInfo"
    private const val USER_NAME = "userName"
    private const val USER_ID = "userId"
    private const val USER_TOKEN = "userToken"
    private const val USER_AVATAR = "userAvatar"


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

    fun saveUserToken(string: String) {
        SPUtils.getInstance(TAG).put(USER_TOKEN, string)

    }

    fun getUserToken(): String {
        return SPUtils.getInstance(TAG).getString(USER_TOKEN)
    }

    fun saveUserAvatar(string: String) {
        SPUtils.getInstance(TAG).put(USER_AVATAR, string)

    }

    fun getUserAvatar(): String {
        return SPUtils.getInstance(TAG).getString(USER_AVATAR)
    }

}