package com.example.maerad7.doseokfcmtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //MyFCMidService 에서 토큰값 최초 호출후 매인 액티비티에서만 토큰 값 호출 가능
        var token = FirebaseInstanceId.getInstance().token
        if(token != null){
            Log.d("test123","token : ${token}")
            var thread = HttpClass(token)
            thread.start()
        }
    }
}
