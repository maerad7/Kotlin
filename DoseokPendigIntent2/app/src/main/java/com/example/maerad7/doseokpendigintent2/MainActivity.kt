package com.example.maerad7.doseokpendigintent2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
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

        //알림
        button.setOnClickListener { view ->
            var builder = getNotificationBuilder1("pending","pending intent")
            builder.setContentTitle("notification 1")
            builder.setContentText("알림메세지1입니다")
            builder.setSmallIcon(android.R.drawable.ic_menu_camera)
            //메세지 누르면 자동종료
            builder.setAutoCancel(true)

            //펜딩인텐트 삽입
            var intent1 = Intent(this,TestActivity1::class.java)


            //인텐트안에 데이터 전달
            intent1.putExtra("data1","문자열데이터1")
            intent1.putExtra("data2",100)

            //PendingIntent.FLAG_UPDATE_CURRENT 데이터 없을때 0 , 데이터 있을때 PendingIntent.FLAG_UPDATE_CURRENT
            var pending1 = PendingIntent.getActivity(this,10,intent1,PendingIntent.FLAG_UPDATE_CURRENT)
            builder.setContentIntent(pending1)

            //멀티액티비티
            var intent2 = Intent(this,TestActivity2::class.java)
            intent2.putExtra("data1","TestActivity2 실행")
            var pending2 = PendingIntent.getActivity(this,100,intent2,PendingIntent.FLAG_UPDATE_CURRENT)
            var builder2 = NotificationCompat.Action.Builder(android.R.drawable.ic_menu_compass,"Action1",pending2)
            var action2 = builder2.build()
            builder.addAction(action2)

            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10,notification)
        }

        button2.setOnClickListener { view ->
            var builder = getNotificationBuilder1("pending","pending intent")
            builder.setContentTitle("notification 2")
            builder.setContentText("알림메세지2입니다")
            builder.setSmallIcon(android.R.drawable.ic_menu_camera)
            //메세지 누르면 자동종료
            builder.setAutoCancel(true)

            //펜딩인텐트 삽입
            var intent1 = Intent(this,TestActivity2::class.java)
            var pending1 = PendingIntent.getActivity(this,0,intent1,0)
            builder.setContentIntent(pending1)

            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(21,notification)

        }

        button3.setOnClickListener {
            var builder = getNotificationBuilder1("pending","pending intent")
            builder.setContentTitle("notification 3")
            builder.setContentText("알림메세지3입니다")
            builder.setSmallIcon(android.R.drawable.ic_menu_camera)
            //메세지 누르면 자동종료
            builder.setAutoCancel(true)

            //펜딩인텐트 삽입
            var intent1 = Intent(this,TestActivity1::class.java)


            //인텐트안에 데이터 전달
            intent1.putExtra("data1","문자열데이터3")
            intent1.putExtra("data2",300)

            //PendingIntent.FLAG_UPDATE_CURRENT 데이터 없을때 0 , 데이터 있을때 PendingIntent.FLAG_UPDATE_CURRENT
            //request코드를 같으면 알림메세지1을 누르고 알림메세지3을 눌렀을때 알림메세지3의 데이터로 덮어쓰기 되는데
            // request 코드를 다르게 하면 뒤에 있는 데이터 덮어쓰길 하지 않는다.
            var pending1 = PendingIntent.getActivity(this,30,intent1,PendingIntent.FLAG_UPDATE_CURRENT)
            builder.setContentIntent(pending1)

            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(30,notification)
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
