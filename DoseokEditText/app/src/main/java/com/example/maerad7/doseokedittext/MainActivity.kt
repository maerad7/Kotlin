package com.example.maerad7.doseokedittext

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2.setOnClickListener {
            view ->
            textView.text = editText.text
        }

        button3.setOnClickListener{
            view ->
            //editText.setText("문자열")
            editText.setText("")
        }
        /*
        var listner1 = EnterListner()
        editText.setOnEditorActionListener(listner1)*/

        //엔터치면 입력
        editText.setOnEditorActionListener { tv, i, keyEvent ->
            textView.text=editText.text
            false
        }

        //타이핑할때마다 입력(문자단위)
        editText.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                textView.text=p0
            }

        })

        /*var watcher = EditWatcher()
        editText.addTextChangedListener(watcher)*/
    }

    //엔터를 누르면 값을 보내는 리스너
    inner class EnterListner:TextView.OnEditorActionListener{

        override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
            textView.text = editText.text

            //true 키보드 내리지 않기 false 키보드 내리기
            return true
        }

    }

    inner class EditWatcher:TextWatcher{

        //문자열이 바뀌고 난 후
        override fun afterTextChanged(p0: Editable?) {

        }
        //문자열이 바뀌기전
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }
        //문자열이 바뀔 때
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            textView.text=p0
        }

    }
}
