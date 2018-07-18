package com.example.maerad7.doseokservice

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var service_intent : Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //서비스 시작
        button.setOnClickListener { view ->
            service_intent = Intent(this,ServiceClass1::class.java)
            startService(service_intent)
        }

        //서비스 정지
        button2.setOnClickListener {
            stopService(service_intent)
        }

        //인텐트 서비스
        button3.setOnClickListener { view ->
            service_intent = Intent(this,ServiceClass2::class.java)
            startService(service_intent)
            finish()
        }

        //포그라운드 서비스 안드로이드 8.0부터는 스타트 포그라운드 서비스로 동작 ->
        // 8.0부터는 포그라운드 서비스 시작후 5초안에 노티피케이션 띄워야된다 . 안하면 강제종료
        button4.setOnClickListener { view ->
            service_intent = Intent(this,ServiceClass3::class.java)
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                startForegroundService(service_intent)
            }else{
            startService(service_intent)
            }
        }
    }
}
