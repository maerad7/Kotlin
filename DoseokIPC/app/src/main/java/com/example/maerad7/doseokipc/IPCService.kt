//서비스 이름
package com.example.maerad7.doseokipc

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.SystemClock
import android.util.Log

//바인더를 이용해서 액티비티가 값을 가져갈 수 있다.

class IPCService : Service() {

    var value = 0
    var thread : ThreadClass? =null
    var binder : IBinder = LocalBinder()

    //외부에서 서비스에 접속하기 되면 호출, 리턴하는 IBinder 객체를 액티비티에서 받게 됨
    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        thread = ThreadClass()
        thread?.start()
        return super.onStartCommand(intent, flags, startId)
    }

    inner class ThreadClass : Thread(){
        override fun run() {
            while(true){
                SystemClock.sleep(1000)
                Log.d("test1","value:${value}")
                value++
            }
        }
    }

    //액티비티와 서비스를 연결가능하게 하는 클래스
    inner class LocalBinder : Binder(){
        fun getService() : IPCService{
            return this@IPCService
        }
    }

    fun getNumber():Int{
        return value
    }
}
