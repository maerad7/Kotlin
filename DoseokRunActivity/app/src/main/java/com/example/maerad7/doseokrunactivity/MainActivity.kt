package com.example.maerad7.doseokrunactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //두번째 액티비티로 이동동
       button.setOnClickListener { view ->
            var intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
        //어플 종료
        button3.setOnClickListener { view ->
            finish()
        }
    }
}
