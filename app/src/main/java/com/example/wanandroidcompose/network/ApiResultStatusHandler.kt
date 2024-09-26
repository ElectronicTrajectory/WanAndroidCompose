package com.example.wanandroidcompose.network

import android.util.Log

/**
 * 对返回结果的状态做通用处理
 *
 * @param onSuccess SUCCESS 状态回调函数
 * @param onFailure FAILURE 状态回调
 * @param onLoading LOADING 状态回调
 */

inline fun <T> MyResult<T>.handleResult(
    crossinline onSuccess: (T?) -> Unit = {},
    crossinline onSuccessMsg: (T?, Int,String) -> Unit = { _, _,_ -> },
    crossinline onFailure: (Int) -> Unit = {},
    crossinline onFailureMsg: (Int, String) -> Unit = { _, _ -> },
    crossinline onLoading: () -> Unit = {}
) {
    Log.d("handleResult", "status = ${this.status}")
    Log.d("handleResult", "code = ${this.code}")
    when (this.status) {
        MyResult.Status.LOADING -> {
            onLoading.invoke()
        }
        MyResult.Status.FAILURE -> {
            handlerApiCode(this.code,this.msg)
            onFailure.invoke(this.code)
            onFailureMsg.invoke(this.code, this.msg)
        }
        MyResult.Status.SUCCESS -> {
            onSuccess.invoke(this.data)
            onSuccessMsg.invoke(this.data, this.code,this.msg)
        }
    }
}
