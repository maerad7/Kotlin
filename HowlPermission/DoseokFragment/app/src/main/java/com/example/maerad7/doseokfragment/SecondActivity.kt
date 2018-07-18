package com.example.maerad7.doseokfragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportFragmentManager.beginTransaction().replace(R.id.framelayout2,MyFragement()).commit()
    }
}
