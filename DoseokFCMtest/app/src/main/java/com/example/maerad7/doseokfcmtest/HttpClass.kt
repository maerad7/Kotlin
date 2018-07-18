package com.example.maerad7.doseokfcmtest

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request

class HttpClass(var token:String) : Thread(){
    override fun run() {
        var client = OkHttpClient()
        var builder = Request.Builder()
        var url = builder.url("http://192.168.0.3:8080/FCMServer/add_token.jsp")

        var bodyBuilder = FormBody.Builder()
        //토큰을 서버에 전달
        bodyBuilder.add("token",token)

        var body = bodyBuilder.build()
        var post = url.post(body)
        var request = post.build()
        client.newCall(request).execute()

    }
}