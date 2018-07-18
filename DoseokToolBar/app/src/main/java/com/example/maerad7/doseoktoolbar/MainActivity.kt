package com.example.maerad7.doseoktoolbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //액션바대신 툴바 사용하도록 설정
        setSupportActionBar(toolbar)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.item1-> textView.text = "메뉴1을 눌렀습니다"
            R.id.item2-> textView.text = "메뉴2을 눌렀습니다"
            R.id.item3-> textView.text = "메뉴3을 눌렀습니다"

        }

        return super.onOptionsItemSelected(item)
    }
}
