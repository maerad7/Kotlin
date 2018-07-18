package com.example.maerad7.doseokstylenotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //노티피케이션에 이미지 넣기
        button.setOnClickListener{view ->

            var builder = getNotificationBuilder1("style","styleNotification")
            builder.setContentTitle("Big Picture")
            builder.setContentText("Big picture Notification")
            builder.setSmallIcon(android.R.drawable.ic_media_next)

            //이미지 넣기
            var big = NotificationCompat.BigPictureStyle(builder)
            //resource는 res폴더 안을 관리한다.
            var bitmap = BitmapFactory.decodeResource(resources,R.drawable.img_android)
            big.bigPicture(bitmap)
            big.setBigContentTitle("Big Content Title")
            big.setSummaryText("Summary Text")

            var notification = builder.build()
            var notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(10,notification)
        }

        //Big Text Style 장문넣기
        button2.setOnClickListener { view ->
            var builder = getNotificationBuilder1("style","styleNotification")
            builder.setContentTitle("Big Text")
            builder.setContentText("Big Text Notification")
            builder.setSmallIcon(android.R.drawable.ic_media_next)

            var big = NotificationCompat.BigTextStyle(builder)
            big.setSummaryText("Summary text")
            big.setBigContentTitle("big content Title")
            big.bigText("장문의 내용을 입력하는 곳장문의 내용을 입력하는 곳장문의 내용을 입력하는 곳장문의 내용을 입력하는 곳장문의 내용을 입력하는 곳장문의 내용을 입력하는 곳장문의 내용을 입력하는 곳")

            var notification = builder.build()
            var notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(20,notification)

        }

        // inBox Style 장문 넣고 펼쳤다 접었다.
        button3.setOnClickListener { view ->
            var builder = getNotificationBuilder1("style","styleNotification")
            builder.setContentTitle("InBox")
            builder.setContentText("InBox Notification")
            builder.setSmallIcon(android.R.drawable.ic_media_next)

            var inbox = NotificationCompat.InboxStyle(builder)
            inbox.setSummaryText("SummmaryText")
            inbox.addLine("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            inbox.addLine("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")

            var notification = builder.build()
            var notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(20,notification)

        }
    }

    fun getNotificationBuilder1(id:String, name:String) : NotificationCompat.Builder{
        var builder : NotificationCompat.Builder? = null
        //안드로이드 오레오 버전 이상부터
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            var notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            //IMPORANCE 중요도 -> 메세지 우선순위
            var notificationChannel= NotificationChannel(id,name, NotificationManager.IMPORTANCE_HIGH)
            //알림 메세지가 올때 단말기 내림
            notificationChannel.enableLights(true)
            notificationChannel.lightColor= Color.RED
            //진동
            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = NotificationCompat.Builder(this,id)
        }else{
            NotificationCompat.Builder(this)
        }
        return builder!!
    }
}
