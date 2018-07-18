package com.example.maerad7.doseokhttpnetwork

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener { view ->
            var thread = NetworkThread()
            thread.start()
        }
    }

    inner class NetworkThread:Thread(){
        override fun run() {

            var site = "http://192.168.0.3:8080/DoseokHttpNetwork/string.jsp"
            var url = URL(site)
            //접속
            var conn = url.openConnection()

            //라인단위로 읽어오기 위해 스트림을 만든다
            var input = conn.getInputStream()
            var isr = InputStreamReader(input,"UTF-8")
            var br = BufferedReader(isr)

            var str:String? = null
            var buf = StringBuffer()

            do{
                str = br.readLine()
                if(str != null){
                    buf.append(str)
                }
            }while(str != null)

            var data = buf.toString()

            runOnUiThread {
                textView.text = data
            }
        }
    }
}
