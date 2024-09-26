package com.example.wanandroidcompose.network

import com.example.wanandroidcompose.common.toast


/**
 * 统一处理错误码
 */
fun handlerApiCode(
    code: Int,
    message: String,
) {
    //不希望弹吐司提示的Code列表,可以用于做其他的独立操作
    val doNotShowToastCodeList = arrayOf(403)
    if (doNotShowToastCodeList.contains(code)){
        when(code){
            403->{
                "身份信息已过期，请重新登录".toast()
//                logout()
            }
        }
    }else{
        message.toast()
    }

}
