package com.example.maerad7.doseokthread

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isRunning = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            view ->
            var now = System.currentTimeMillis()
            textView.text="버튼 클릭 : ${now}"
        }
/*
        while(true){
            var now = System.currentTimeMillis()
            textView2.text= "무한루프: ${now}"
        }*/
        isRunning = true
        var thread = ThreadClass1()
        thread.start()
    }

    //쓰레드가 동작하고 현재시간을 Log에 남김, 액티비티 종료시켜도 쓰레드는 동작함(메인쓰레드만 종료)
    inner class ThreadClass1 : Thread(){
        override fun run(){
            while(isRunning){
                SystemClock.sleep(100)
                var now = System.currentTimeMillis()
                Log.d("test1","쓰레드: ${now}")

                //오레오이상부터 쓰레드에서 화면 조작 가능
                //그 이하 버전은 에러발생 -> 강제종료
                textView2.text="쓰레드: ${now}"
            }
        }
    }

    //액티비티 종료될때 쓰레드 종료
    override fun onDestroy() {
        super.onDestroy()
        isRunning=false
    }
}
