package com.example.wanandroidcompose.network

import android.content.Intent
import com.example.wanandroidcompose.App
import com.example.wanandroidcompose.common.toast


/**
 * 统一处理错误码
 */
fun handlerApiCode(
    code: Int,
    message: String,
) {
    //不希望弹吐司提示的Code列表,可以用于做其他的独立操作
    val doNotShowToastCodeList = arrayOf(403,-1001)
    if (doNotShowToastCodeList.contains(code)) {
        when (code) {
            -1001 -> {
                App.application.sendBroadcast(
                    Intent("Logout")
                )
            }
        }
    } else {
        message.toast()
    }

}
