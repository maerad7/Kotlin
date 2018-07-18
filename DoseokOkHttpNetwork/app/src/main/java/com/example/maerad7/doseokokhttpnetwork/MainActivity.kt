package com.example.maerad7.doseokokhttpnetwork

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            var thread = NetworkThread()
            thread.start()
        }
    }

    inner class NetworkThread : Thread(){
        override fun run() {

            var client = OkHttpClient()

            var builder = Request.Builder()
            var url = builder.url("http://google.com")

            //요청
            var request = url.build()

            var callback = CallBack1()

            client.newCall(request).enqueue(callback)
        }
    }
    inner class CallBack1 : Callback {
        //응답 실패
        override fun onFailure(call: Call?, e: IOException?) {
        }
        //서버로 부터 응답을 받았을 경우
        override fun onResponse(call: Call?, response: Response?) {

            var result = response?.body()?.string()

            runOnUiThread{
                textView.text = result
            }
        }
    }
}
