package com.example.maerad7.doseokhandler2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var handler :Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            var time = System.currentTimeMillis()
            textView.text = "버튼 클릭: ${time}"
        }
/*      문제발생 코드
        while(true){
            SystemClock.sleep(100)
            var time = System.currentTimeMillis()
            textView2.text="while: ${time}"*/


            handler = Handler()
            var thread = ThreadClass()
            //post안에 스레드 객체 넣기
         //   handler?.post(thread)
            //핸들러에 딜레이넣기
            handler?.postDelayed(thread,100)
        }



    inner class ThreadClass:Thread(){
        override fun run(){
            var time = System.currentTimeMillis()
            textView2.text = "Handler 클릭: ${time}"

            //반복
           // handler?.post(this)
            //핸들러에 딜레이넣기
            handler?.postDelayed(this,100)
        }
    }
}