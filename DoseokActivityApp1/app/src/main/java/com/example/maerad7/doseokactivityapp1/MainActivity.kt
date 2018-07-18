package com.example.maerad7.doseokactivityapp1

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val SECONDACTIVITY=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            var intent = Intent("com.test.second")
            intent.putExtra("data1",100)
            intent.putExtra("data2",11.11)
            startActivityForResult(intent,SECONDACTIVITY)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode== RESULT_OK){
            var value1 = data?.getIntExtra("value1",0)
            var value2 = data?.getDoubleExtra("value2",0.0)
            textView.text="value1 : ${value1}\n"
            textView.append("value2 :${value2}")
        }
    }
}
