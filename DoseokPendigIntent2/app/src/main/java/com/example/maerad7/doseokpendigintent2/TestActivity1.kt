package com.example.maerad7.doseokpendigintent2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_test1.*

class TestActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)

        var data1 = intent.getStringExtra("data1")
        var data2 = intent.getIntExtra("data2",0)
        textView.text="data1 : ${data1}\n"
        textView.append("data2:${data2}")
    }
}
