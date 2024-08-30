package com.example.network

class BaseRespModel<T>(
    val data: T,
):SuperBaseModel()

open class SuperBaseModel (
    val success:Boolean = false,
    val errorMessage: String = "",
    val errorCode: Int = -1,
)