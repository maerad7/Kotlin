package com.example.maerad7.doseoksenddata

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        //두번째 파라미터 default 값
        var data1 = intent.getIntExtra("data1",0)
        var data2 = intent.getDoubleExtra("data2",0.0)
        var data3 = intent.getBooleanExtra("data3",false)
        var data4 = intent.getStringExtra("data4")

        textView2.text="data1 : ${data1}\n"
        textView2.append("data2 : ${data2}\n")
        textView2.append("data3 : ${data3}\n")
        textView2.append("data4 : ${data4}\n")

        button2.setOnClickListener { view ->
            var intent2 = Intent()
            intent2.putExtra("value1",200)
            intent2.putExtra("value2",22.2)
            intent2.putExtra("value3",true)
            intent2.putExtra("value3","문자열")

            //resultCode 설정
            setResult(Activity.RESULT_OK,intent2)

            finish()
        }
    }
}
