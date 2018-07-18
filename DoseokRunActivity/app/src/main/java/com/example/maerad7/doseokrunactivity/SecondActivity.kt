package com.example.maerad7.doseokrunactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //세컨드액비비티 종료
        button2.setOnClickListener { view ->
            finish()
        }

    }
}
