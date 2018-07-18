package com.example.maerad7.doseokfcmtest

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

class MyFCMidService : FirebaseInstanceIdService() {
    //구글 서버로부터 단말기 토큰값 받는 것을 성공하면 호출

    override fun onTokenRefresh() {
        var token = FirebaseInstanceId.getInstance().token
        Log.d("test123","token : ${token}")
        var thread = HttpClass(token!!);
        thread.start()
    }
}
