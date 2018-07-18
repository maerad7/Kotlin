package com.example.maerad7.doseokservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import java.lang.UnsupportedOperationException

class ServiceClass1 : Service() {
    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var thread = ThreadClass()
        thread.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("test1","서비스 실행종료")
    }

    inner class ThreadClass : Thread(){
        override fun run() {
            var idx = 0
            while (idx<10){
                SystemClock.sleep(1000)
                var time = System.currentTimeMillis()
                Log.d("test1","Service Running : ${time}")
                idx++
            }
        }
    }
}
