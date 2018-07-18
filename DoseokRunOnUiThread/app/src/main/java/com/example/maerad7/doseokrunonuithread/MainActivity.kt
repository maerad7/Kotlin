package com.example.maerad7.doseokrunonuithread

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isRunning : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            view ->
            var time = System.currentTimeMillis()
            textView.text = "버튼 클릭: ${time}"

        }
        isRunning = true
        var thread = ThreadClass()
        thread.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
    inner class ThreadClass : Thread(){
        override fun run() {
            while(isRunning){
                SystemClock.sleep(1000)
                var time = System.currentTimeMillis()
                Log.d("test1","쓰레드 : ${time}")
                //textView2.text = "쓰레드 : ${time}"

                runOnUiThread{
                    textView2.text="쓰레드 : ${time}"
                }
            }
        }
    }
}
