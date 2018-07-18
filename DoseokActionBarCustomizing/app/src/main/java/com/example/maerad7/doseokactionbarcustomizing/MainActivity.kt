package com.example.maerad7.doseokactionbarcustomizing

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        //액션 바 커스터마이징을 허용한다.
        supportActionBar?.setDisplayShowCustomEnabled(true)
        //기존 액션바의 요소를 숨긴다
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        var actionView =  layoutInflater.inflate(R.layout.custom_actionbar,null)
        supportActionBar?.customView = actionView

        var actionText = actionView.findViewById<TextView>(R.id.textView)
        actionText.text="커스텀 액션바"
        actionText.setTextColor(Color.WHITE)

        var actionBtn = actionView.findViewById<Button>(R.id.button)
        actionBtn.setOnClickListener {
            Toast.makeText(this,"버튼을 눌렀습니다",Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
