package com.example.maerad7.doseokcontext

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.framelayout,MyFragment()).commit()

        //Toast.makeText(this,"토스트메세지",Toast.LENGTH_LONG).show()
    }
}
