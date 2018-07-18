package com.example.maerad7.doseokradiobutton

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        var listner = RadioListner()
        group1.setOnCheckedChangeListener(listner)
        group2.setOnCheckedChangeListener(listner)
*/

        //람다식
        group1.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.radioButton->textView.text="체크 이벤트= raidobutton1"
                R.id.radioButton2->textView.text="체크 이벤트= raidobutton2"
                R.id.radioButton3->textView.text="체크 이벤트= raidobutton3"
            }
        }
        group2.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.radioButton4->textView2.text="체크 이벤트= raidobutton4"
                R.id.radioButton5->textView2.text="체크 이벤트= raidobutton5"
                R.id.radioButton6->textView2.text="체크 이벤트= raidobutton6"

            }
        }
        button.setOnClickListener{
            view ->

            //현재 체크되어져 있는 라디오 값의 아이디를 가져온다.
            when(group1.checkedRadioButtonId) {
                R.id.radioButton -> textView.text = "radiobutton1"
                R.id.radioButton2 -> textView.text = "raidobutton2"
                R.id.radioButton3 -> textView.text = "raidobutton3"

            }
            when(group2.checkedRadioButtonId){
                R.id.radioButton4 -> textView2.text="radiobutton4"
                R.id.radioButton5 -> textView2.text="radiobutton5"
                R.id.radioButton6 -> textView2.text="radiobutton6"
            }
        }
    }

    inner class RadioListner:RadioGroup.OnCheckedChangeListener{
        //p1 -> 라디오 버튼의 아이디
        override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
            when(p0?.id){
                R.id.group1->
                        when(p1){
                            R.id.radioButton->textView.text="체크 이벤트= raidobutton1"
                            R.id.radioButton2->textView.text="체크 이벤트= raidobutton2"
                            R.id.radioButton3->textView.text="체크 이벤트= raidobutton3"

                        }
                R.id.group2->
                    when(p1){
                        R.id.radioButton4->textView2.text="체크 이벤트= raidobutton4"
                        R.id.radioButton5->textView2.text="체크 이벤트= raidobutton5"
                        R.id.radioButton6->textView2.text="체크 이벤트= raidobutton6"

                    }
            }
        }

    }
}
