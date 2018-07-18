package com.example.maerad7.doseokbutton

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(listner)
        button2.setOnClickListener(listner)
    }
    var listner = View.OnClickListener {
        view ->
        when(view.id){
            R.id.button ->
                textView.text = "1번버튼"
            R.id.button2 ->
                textView.text = "2번버튼"
        }
    }
}
