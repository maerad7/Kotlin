package com.example.maerad7.doseokresource

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //XML에서 문자열 가져오기
        button.setOnClickListener {
//            var str1 = resources.getString(R.string.str2)
//            textView.text = str1

            textView.setText(R.string.str2)

        }
        //XML 에서 문자열 배열 가져오기
        button2.setOnClickListener {
            textView.text=""
            var str_array = resources.getStringArray(R.array.data_array)
            for(str1 : String in str_array){
                textView.append("${str1}\n")
            }
        }

        //색상관리
        button3.setOnClickListener {
//            textView.setTextColor(Color.YELLOW)
//            var color = Color.rgb(26,106,129)
            //알파 = 투명도
//            var color = Color.argb(50,26,106,129)
            var color = ContextCompat.getColor(this,R.color.color1)
            textView.setTextColor(color)
        }

        //크기관리
        button4.setOnClickListener {
            var px = resources.getDimension(R.dimen.px)
            var dp =resources.getDimension(R.dimen.dp)
            var sp =resources.getDimension(R.dimen.sp)
            var inch =resources.getDimension(R.dimen.inch)
            var mm =resources.getDimension(R.dimen.mm)
            var pt =resources.getDimension(R.dimen.pt)

            textView.text="px :${px}\n"
            textView.append("dp:${dp}\n")
            textView.append("sp:${sp}\n")
            textView.append("inch:${inch}\n")
            textView.append("mm:${mm}\n")
            textView.append("pt:${pt}\n")

        }
    }
}
