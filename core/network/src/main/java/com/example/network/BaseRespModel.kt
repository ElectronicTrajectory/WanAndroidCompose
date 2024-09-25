package com.example.network

class BaseRespModel<T>(
    val data: T,
):SuperBaseModel()

open class SuperBaseModel (
    val errorMsg: String = "",
    val errorCode: Int = -1,
)