package com.example.maerad7.doseoknotification2


import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
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

        //8.0이하만 NotificationCompat 사용가능 8.0부터는 Notification Channel 사용
        button.setOnClickListener { view ->
            var builder = getNotificationBuilder1("channel1","첫번째 채널")

            //트레이에 알림아이콘과 티커문자가 나온다.
            builder.setTicker("Ticker")//4.1버전부터 표시되지 않는다.
            builder.setSmallIcon(android.R.drawable.ic_menu_search)

            var bitmap = BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher)
            builder.setLargeIcon(bitmap)
            builder.setNumber(100)//4.1버전부터 표시되지 않는다.

            //ture 면 터치했을때 메세지가 자동으로 제거
            builder.setAutoCancel(true)
            builder.setContentTitle("Content title")
            builder.setContentText("Content Text")

            var notification = builder.build()
            var mng  = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            //id를 바꾸면 메세지가 쌓임
            mng.notify(10,notification)
        }

        button2.setOnClickListener { view ->
            var builder = getNotificationBuilder1("channel2","2번째 채널")

            //트레이에 알림아이콘과 티커문자가 나온다.
            builder.setTicker("Ticker")//4.1버전부터 표시되지 않는다.
            builder.setSmallIcon(android.R.drawable.ic_menu_search)

            var bitmap = BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher)
            builder.setLargeIcon(bitmap)
            builder.setNumber(100)//4.1버전부터 표시되지 않는다.

            //ture 면 터치했을때 메세지가 자동으로 제거
            builder.setAutoCancel(true)
            builder.setContentTitle("Content title2")
            builder.setContentText("Content Text2")

            var notification = builder.build()
            var mng  = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            //id를 바꾸면 메세지가 쌓임
            mng.notify(20,notification)
        }

        button3.setOnClickListener { view ->
            var builder = getNotificationBuilder1("channel3","3번째 채널")

            //트레이에 알림아이콘과 티커문자가 나온다.
            builder.setTicker("Ticker")//4.1버전부터 표시되지 않는다.
            builder.setSmallIcon(android.R.drawable.ic_menu_search)

            var bitmap = BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher)
            builder.setLargeIcon(bitmap)
            builder.setNumber(100)//4.1버전부터 표시되지 않는다.

            //ture 면 터치했을때 메세지가 자동으로 제거
            builder.setAutoCancel(true)
            builder.setContentTitle("Content title3")
            builder.setContentText("Content Text3")

            var notification = builder.build()
            var mng  = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            //id를 바꾸면 메세지가 쌓임
            mng.notify(30,notification)
        }
    }

    fun getNotificationBuilder1(id:String, name:String) : NotificationCompat.Builder{
        var builder : NotificationCompat.Builder? = null
        //안드로이드 오레오 버전 이상부터
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            var notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            //IMPORANCE 중요도 -> 메세지 우선순위
            var notificationChannel=NotificationChannel(id,name,NotificationManager.IMPORTANCE_HIGH)
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
