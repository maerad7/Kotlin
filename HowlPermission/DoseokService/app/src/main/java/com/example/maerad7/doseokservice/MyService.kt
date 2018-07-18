package com.example.maerad7.doseokservice

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service(){
    //서비스가 생성 될때 작동
    override fun onCreate() {
        super.onCreate()
    }
    //생성되기 직전에 작동(만들었는데 또 실행 됬을때 onresume처럼)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

            Thread{
                run{
                    while (true){
                        Thread.sleep(3000)
                        println("서비스 실행 중입니다.")
                    }
                }
            }.start()

        //서비스가 오류로 종류되어도 서비스가 되살아나도록 설정해주는 플래그 값
        return START_STICKY
    }
    // 서비스가 제거 될 때 작동
    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(p0: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}