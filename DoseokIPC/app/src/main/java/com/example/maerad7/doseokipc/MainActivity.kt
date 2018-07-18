package com.example.maerad7.doseokipc

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import kotlinx.android.synthetic.main.activity_main.*

//서비스에서 데이터를 가져올때 서비스에서 쓰레드가 동작한다면 쓰레드가 시작하고 나서 가져와야한다.
//
//왜냐하면 서비스에 접속하려고 시도했을때 접속중인 쓰레드가 동작하지 않는다고 하면
//동작시키고 접속할 수 있는데 이런 방식으로 하면 접속해제 했을때 쓰레드가 종료된다.
//앱을 실행할때 마다 자동으로 서비스에 접속시킬거다, 서비스가 스타트가 아닌경우엔 서비스를 시작하고 접속하고 서비스가 가동중인 경우 서비스를 가동시키지 않는다.


class MainActivity : AppCompatActivity() {

    //ipc서비스 객체의 주소 값을 받기 위해
    var ipc_service : IPCService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent = Intent(this,IPCService::class.java)
        //데이터를 받아오면 서비스가 중지되기 때문에 다시 동작시키기위해 아래의 코드 작성
        if(isServiceRunning("com.example.maerad7.doseokipc")==false){
            startService(intent)
        }
        bindService(intent,mConnection,Context.BIND_AUTO_CREATE)

        //서비스값 가져오기
        button.setOnClickListener {
            view ->
            var value = ipc_service?.getNumber()
            textView.text = "value : ${value}"
        }
    }

    //종료할때 서비스 연결해제
    override fun onDestroy() {
        super.onDestroy()
        unbindService(mConnection)
    }
    //서비스가 동작중인지 확인하는 메소드

    fun isServiceRunning(name:String):Boolean{
        var manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        //현재 동작 중인 모든 서비스의 정보를 가져온다
       for(service : ActivityManager.RunningServiceInfo in manager.getRunningServices(Int.MAX_VALUE)){
            if(service.service.className.equals(name)){
                return true
            }
        }
        return false
    }

    private val mConnection = object : ServiceConnection{
        //서비스가 끊겼을때 호출
        override fun onServiceDisconnected(p0: ComponentName?) {
            ipc_service=null
        }

        //서비스에 접속했을 때 호출, 서비스의 IBinder가 p1으로 들어온다
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            val binder = p1 as IPCService.LocalBinder
            ipc_service = binder.getService()
        }

    }
}
