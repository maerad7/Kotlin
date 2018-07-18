package com.example.maerad7.doseokhandler3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.SystemClock
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isRunning = false
    var handler:DisplayHandler? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener { view ->
            var time = System.currentTimeMillis()
            textView.text = "버튼 클릭: ${time}"
        }
        handler = DisplayHandler()

        isRunning=true
        var thread = ThreadClass()
        thread.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning =false
    }
    inner class ThreadClass:Thread(){
        var a1= 10
        var a2 =20
        override fun run() {
            while(isRunning){
                SystemClock.sleep(100)
                var time = System.currentTimeMillis()
                Log.d("test1","쓰레드: ${time}")
                //안드로이드 8.0이상부터 이
                //textView2.text="쓰레드 : ${time}"
                //메인스레드가 한가할때 handleMessage 호출한다
                //handler?.sendEmptyMessage(0)
                //핸들러에 데이터 전달 ->sendMessage
             /*   var msg = Message()
                msg.what = 0
                //값을 여러개 넣으려면 객체나 배열로 넣자
                msg.obj= time
                handler?.sendMessage(msg)*/
                var msg2 = Message()
                msg2.what =1
                msg2.arg1 = a1++
                msg2.arg2 = a2++
                msg2.obj = " 안녕하세요"
                handler?.sendMessage(msg2)
            }
        }
    }
    //핸들러 상속받는 클래스
    inner class DisplayHandler : Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            //메세지별로 처리
            if(msg?.what == 0) {
                //var time = System.currentTimeMillis()
                textView2.text = "Handler: ${msg?.obj}"
            }else if(msg?.what==1){
                textView2.text="${msg?.arg1}, ${msg.arg2}, ${msg.obj}"
            }
        }
    }
}
