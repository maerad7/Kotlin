package com.example.maerad7.doseoktoast

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener{
            view ->
            var t1 = Toast.makeText(this,"Toast message",Toast.LENGTH_SHORT)
            t1.show()
        }


        button2.setOnClickListener { view ->

            //커스텀뷰 호출하기
            var view1 = layoutInflater.inflate(R.layout.custom_toast,null)
            //배경화면 설정
            view1?.setBackgroundResource(android.R.drawable.toast_frame)

            //뷰 내의 그림 설정
            var image_view:ImageView? = view1.findViewById<ImageView>(R.id.imageView)
            image_view?.setImageResource(R.drawable.abc)

            //뷰 내의 텍스트 설정
            var text_view : TextView? = view1.findViewById<TextView>(R.id.textView)
            text_view?.text = "메세지 입니다"
            text_view?.setTextColor(Color.BLUE)

            var t2 = Toast(this)
            t2.view = view1

            //토스트의 위치 설정
            t2.setGravity(Gravity.CENTER,0,0)

            t2.show()

        }
    }
}
