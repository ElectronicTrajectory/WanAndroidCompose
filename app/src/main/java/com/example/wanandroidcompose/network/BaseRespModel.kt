package com.example.wanandroidcompose.network

class BaseRespModel<T>(
    val data: T,
): SuperBaseModel()

open class SuperBaseModel (
    val errorMsg: String = "",
    val errorCode: Int = -1,
)