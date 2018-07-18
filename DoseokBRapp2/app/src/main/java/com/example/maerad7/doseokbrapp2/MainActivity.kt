package com.example.maerad7.doseokbrapp2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { view ->
            var intent = Intent()
            intent.setClassName("com.example.maerad7.doseokbrapp1","com.example.maerad7.doseokbrapp1.TestReceiver")
            //데이터 저장
            intent.putExtra("data1",10)
            intent.putExtra("data2",11.11)

            sendBroadcast(intent)
        }
        button2.setOnClickListener { view ->
            var intent = Intent("com.test.brapp1")

            //데이터 저장
            intent.putExtra("data1",100)
            intent.putExtra("data2",11.111)

            sendBroadcast(intent)
        }
    }
}
