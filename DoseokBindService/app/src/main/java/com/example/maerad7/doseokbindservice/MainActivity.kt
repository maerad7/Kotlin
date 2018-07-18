package com.example.maerad7.doseokbindservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ServiceConnection {

    var isService = false
    //서비스 연결이 해제 됬을때 호출
    override fun onServiceDisconnected(p0: ComponentName?) {
        isService = false
    }
    //서비스 연결이 됬을때 호출
    override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
        var myBInder = p1 as MyService.MyBinder
        var service = myBInder.getService()
        isService = true
        print(service.message)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //서비스랑 연결
        var service = Intent(this,MyService::class.java)
        bindService(service,this, Context.BIND_AUTO_CREATE)

        button_service_state.setOnClickListener{
            if(isService){
                Toast.makeText(this,"서비스 연결", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"서비스 연결 종료", Toast.LENGTH_LONG).show()

            }
        }
        button_service_detach.setOnClickListener{
           //서비스 종료
            if(isService){
                unbindService(this)
                isService= false

            }

        }
    }
}
