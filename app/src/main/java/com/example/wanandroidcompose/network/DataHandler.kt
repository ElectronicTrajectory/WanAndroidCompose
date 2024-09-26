package com.example.wanandroidcompose.network

import android.util.Log
import com.blankj.utilcode.util.LogUtils
import com.google.gson.JsonParseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * 获取基于BaseRespModel的统一格式数据
 */
fun logd(tag: String, str: String) {
    Log.d(tag, str)
}

suspend fun <T> getResult(call: suspend () -> Response<BaseRespModel<T>>): Flow<MyResult<T>> =
    flow {

        val response = call.invoke()
        if (response.isSuccessful) {
            val body = response.body()
            logd("getResult:data", body?.data.toString())
            if (body != null) {
                if (body.errorCode == 0) {
                    emit(MyResult.success(body.errorCode, body.data))
                } else {
                    emit(MyResult.failure(body.errorCode, body.errorMsg, body.data))
                }
            } else {
                emit(MyResult.failure(response.code(), "Response body is null"))
            }
        } else {
            emit(MyResult.failure(response.code(), response.message()))
        }

    }.catch { e ->
        logd("getResult:Error", e.toString())
        emit(handleResponseException(e))
    }

/**
 * 获取任意格式数据
 */
suspend fun <T> getResultT(call: suspend () -> Response<T>): Flow<MyResult<T>> = flow {
    try {
        val response = call.invoke()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                logd("getResultT:data", body.toString())
                emit(MyResult.success(response.code(), body))
            }
        } else {
            emit(MyResult.failure(response.code(), response.message()))
        }
    } catch (e: Exception) {
        logd("getResultT:Error", e.toString())
        emit(handleResponseException(e))
    }
}


fun <T> resultFlow(flow: suspend () -> Flow<MyResult<T>>): Flow<MyResult<T>> =
    flow {
        flow().collect { result ->
            when (result.status) {
                MyResult.Status.SUCCESS -> emit(MyResult.success(result.code, result.data))
                MyResult.Status.FAILURE -> emit(MyResult.failure(result.code, result.msg, null))
                else -> emit(MyResult.loading())
            }
        }
    }

/**
 * 统一处理基本异常
 */
private fun <T> handleResponseException(e: Throwable): MyResult<T> {
    return when (e) {
        is HttpException,
        is SocketException,
        is SocketTimeoutException,
        is UnknownHostException -> {
            MyResult.failure(-1, "网络异常")
        }

        is JsonParseException -> {
            MyResult.failure(-1, "数据格式转换错误")
        }

        else -> {
            MyResult.failure(-1, "服务异常")
        }
    }
}