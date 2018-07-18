package com.example.maerad7.doseokfragment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout1,MyFragement()).commit()

        button.setOnClickListener{
            startActivity(Intent(this,SecondActivity::class.java))
        }

    }
}
