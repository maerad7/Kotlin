package com.example.maerad7.doseokokhttp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.AsyncTask.execute
import com.google.gson.Gson
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val JSON = MediaType.parse("application/json; charset=utf-8")

        val client = OkHttpClient()

        var url="https://openapi.naver.com/v1/papago/n2mt"
        var json = JSONObject()
        json.put("source","ko")
        json.put("target","en")
        json.put("text","안녕하세요")


        val body = RequestBody.create(JSON, json.toString())

        //헤더에 네이버 아이디 와 키 값 + 요청 보내기
        val request = Request.Builder()
                .header("X-Naver-Client-Id","NKS4N8l83jsGeEfKTcaF")
                .addHeader("X-Naver-Client-Secret","lH2QKM5cj7")
                .url(url)
                .post(body)
                .build()

        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call?, e: IOException?) {
            }

            //응답받기 객체가 제이슨이라서 gson을 사용해 값을 뽑아냄
            override fun onResponse(call: Call?, response: Response?) {
                var str = response!!.body()!!.string()
                println(str)
                var papagoDTO= Gson().fromJson<PapagoDTO>(str,PapagoDTO::class.java)
                println(papagoDTO.message!!.result!!.translatedText)
            }

        })
    }
}
