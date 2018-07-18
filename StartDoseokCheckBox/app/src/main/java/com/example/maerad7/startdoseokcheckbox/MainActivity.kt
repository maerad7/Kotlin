package com.example.maerad7.startdoseokcheckbox

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            view ->
            textView.text = ""
            if(checkBox.isChecked==true){
                //문자열 뒤에 내용 추가
                textView.append("체크박스1이 체크되었습니다.\n")
            }
            if(checkBox2.isChecked==true) {
                //문자열 뒤에 내용 추가
                textView.append("체크박스2이 체크되었습니다.\n")
            }
            if(checkBox2.isChecked==true) {
                //문자열 뒤에 내용 추가
                textView.append("체크박스3이 체크되었습니다.\n")
            }
        }

        //체크하기
        button2.setOnClickListener { view ->
            checkBox.isChecked = true
            checkBox2.isChecked = true
            checkBox3.isChecked = true
        }

        //체크해제하기
        button3.setOnClickListener { view ->
            checkBox.isChecked = false
            checkBox2.isChecked = false
            checkBox3.isChecked = false
        }

        //체크반전
        button4.setOnClickListener { view ->
            checkBox.toggle()
            checkBox2.toggle()
            checkBox3.toggle()
        }
        //cpzm
        var listner1 = CheckBoxListner()
        checkBox.setOnCheckedChangeListener(listner1)

        checkBox2.setOnCheckedChangeListener{
            compoundButton, b ->
            if(b== true){
                textView.text=" 이벤트 : 체크박스2이 체크되었습니다."
            }else{
                textView.text=" 이벤트 : 체크박스2이 해제되었습니다."

            }
        }

        checkBox3.setOnCheckedChangeListener{
            compoundButton, b ->
            if(b== true){
                textView.text=" 이벤트 : 체크박스3이 체크되었습니다."
            }else{
                textView.text=" 이벤트 : 체크박스3이 해제되었습니다."

            }
        }

    }
    inner class CheckBoxListner : CompoundButton.OnCheckedChangeListener{

        //첫번째 파라미터 : 체크상태가 변경될때 주소값 , 두번째 파라미터 : 체크가 되면 true, 아니면 false
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            if(p1 == true){
                textView.text=" 이벤트 : 체크박스1이 체크되었습니다."
            }else{
                textView.text=" 이벤트 : 체크박스1이 해제되었습니다."

            }
        }

    }

}
