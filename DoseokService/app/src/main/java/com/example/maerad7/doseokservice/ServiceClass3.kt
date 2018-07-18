package com.example.maerad7.doseokservice

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import android.os.SystemClock
import android.support.v4.app.NotificationCompat
import android.util.Log

//포그라운드 서비스

class ServiceClass3 : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        //알림 메세지
        var builder: NotificationCompat.Builder? =null

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            var channel =  NotificationChannel("test1","Service",NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor= Color.RED
            channel.enableVibration(true)
            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this,"test1")
        }else{
            builder = NotificationCompat.Builder(this)
        }
        builder.setSmallIcon(android.R.drawable.ic_menu_search)
        builder.setContentTitle("서비스 가동")
        builder.setContentText("서비스 가동중입니다.")
        var notification = builder?.build()

        //아이디는 노티피케이션 아이디
        startForeground(10,notification)

        var thread = ThreadClass()
        thread.start()
        return super.onStartCommand(intent, flags, startId)
    }
    inner class ThreadClass : Thread(){
        override fun run() {
            var idx = 0
            while (idx<10){
                SystemClock.sleep(1000)
                var time = System.currentTimeMillis()
                Log.d("test1","Forground Service Running : ${time}")
                idx++
            }
        }
    }
}
