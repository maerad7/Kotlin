package com.example.maerad7.doseoksharepreference

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SahredPereference 객체
        var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        //sharedpeference 수정 객체
        var edit = sharedPreferences.edit()
        //입력된 글자를 가져옴
        var save_string = sharedPreferences.getString("userid","아이디를 입력해주세요")
        editText_email.setText(save_string)

        button_save.setOnClickListener {
            //입력
            edit.putString("userid", editText_email.text.toString()).commit()
        }
    }
}
// edit.putBoolean,editputInt,edit.putFloat,edit.putLong,edit.PutStringSet 등이 있다
