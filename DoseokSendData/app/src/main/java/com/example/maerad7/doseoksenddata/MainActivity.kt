package com.example.maerad7.doseoksenddata

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val SECONDACTIVITY = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            var intent = Intent(this,SecondActivity::class.java)
            //데이터 입력
            intent.putExtra("data",1)
            intent.putExtra("data2",11.11)
            intent.putExtra("data3",true)
            intent.putExtra("data4","문자열1")

            startActivityForResult(intent,SECONDACTIVITY)
        }
    }
    //세컨드 액티비티의 intent2가 data에 들어온다
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== Activity.RESULT_OK){
            var value1 = data?.getIntExtra("value1",0)
            var value2 = data?.getDoubleExtra("value2",0.0)
            var value3 = data?.getBooleanExtra("value3",false)
            var value4 = data?.getStringExtra("value4")

            textView.text="value1 : ${value1}\n"
            textView.append("value2 : ${value2}\n")
            textView.append("value3 : ${value3}\n")
            textView.append("value4 : ${value4}\n")



        }
    }
}
