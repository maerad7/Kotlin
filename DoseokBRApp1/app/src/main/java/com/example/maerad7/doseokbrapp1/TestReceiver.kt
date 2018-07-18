package com.example.maerad7.doseokbrapp1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class TestReceiver : BroadcastReceiver() {
    //브로드캐스트가 동작하면 onReceive가 호출된다.
    override fun onReceive(context: Context, intent: Intent) {

        //app2의 데이터를 받음
        var data1 = intent.getIntExtra("data1",0)
        var data2= intent.getDoubleExtra("data2",0.0)
        var str1 = "data1 : ${data1}\ndata2: ${data2}"
        var t1 = Toast.makeText(context,str1,Toast.LENGTH_SHORT)
        t1.show()

    }
}
