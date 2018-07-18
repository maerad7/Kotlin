package com.example.maerad7.doseokbindservice

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MyService:Service(){
    var message : String? = null


    override fun onCreate() {
        super.onCreate()
        message= "서비스가 작동 중입니다."
    }
    //앱이랑 연결시키는 부분
    inner class MyBinder : Binder(){
        fun getService(): MyService{
            return this@MyService
        }
    }
    override fun onBind(p0: Intent?): IBinder {
        return MyBinder()
    }
    //앱과 서비스가 연결이 끊겼을때
    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }
    //서비스가 사라졌을때
    override fun onDestroy() {
        super.onDestroy()
    }
}