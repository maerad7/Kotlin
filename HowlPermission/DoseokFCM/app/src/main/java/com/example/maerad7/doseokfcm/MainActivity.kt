package com.example.maerad7.doseokfcm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.iid.FirebaseInstanceId

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var token = FirebaseInstanceId.getInstance().token

        println(token)
    }
}
