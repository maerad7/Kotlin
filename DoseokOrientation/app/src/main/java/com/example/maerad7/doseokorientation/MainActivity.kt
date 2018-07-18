package com.example.maerad7.doseokorientation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //처음 화면을 만들때는 null 이지만 화면회전할때는 bundle이 들어온다
        if (savedInstanceState != null) {
            textView.text = savedInstanceState?.getString("data1")
        }


        button.setOnClickListener { view ->
            textView.text = editText.text
        }
    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString("data1", textView.text.toString())

    }

}
