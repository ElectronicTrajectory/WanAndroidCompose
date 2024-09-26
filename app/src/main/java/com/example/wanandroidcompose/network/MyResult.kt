package com.example.wanandroidcompose.network

open class MyResult<T>(
    val status: Status,
    val code: Int,
    val msg: String,
    val data: T?
) {
    enum class Status {
        SUCCESS,
        FAILURE,
        LOADING
    }

    companion object {
        fun <T> success(code: Int, data: T? = null): MyResult<T> {
            return MyResult(Status.SUCCESS, code, "", data)
        }

        fun <T> failure(code: Int, msg: String, data: T? = null): MyResult<T> {
            return MyResult(Status.FAILURE, code, msg, data)
        }

        fun <T> loading(data: T? = null): MyResult<T> {
            return MyResult(Status.LOADING, -1, "", data)
        }

    }

}