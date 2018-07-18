package com.example.maerad7.doseokoptionmenu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //xml로 메뉴 만들때 사용
        //menuInflater.inflate(R.menu.option_menu,menu)

        //코드에서 메뉴 만들때
        menu?.add(Menu.NONE,Menu.FIRST+1,Menu.NONE,"코드메뉴1")
        menu?.add(Menu.NONE,Menu.FIRST+2,Menu.NONE,"코드메뉴2")

        var sub:Menu? = menu?.addSubMenu("메뉴3")
        sub?.add(Menu.NONE,Menu.FIRST+3,Menu.NONE,"코드메뉴3")
        sub?.add(Menu.NONE,Menu.FIRST+4,Menu.NONE,"코드메뉴4")

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        //메뉴의 id값을 가져온다
       /* when(item?.itemId){
            R.id.item1_1 -> textView.text = "메뉴 1-1을 눌렀습니다"
            R.id.item1_2 -> textView.text = "메뉴 1-2을 눌렀습니다"
            R.id.item2 -> textView.text = "메뉴 2을 눌렀습니다"
            R.id.item3-> textView.text = "메뉴 3을 눌렀습니다"

        }*/
        when(item?.itemId){
            Menu.FIRST+1 -> textView.text = " 코드 메뉴를 1을 눌렀습니다"
            Menu.FIRST+2 -> textView.text= " 코드메뉴 2를 눌렀습니다"
            Menu.FIRST+3 -> textView.text= " 코드메뉴 3를 눌렀습니다"
            Menu.FIRST+4 -> textView.text= " 코드메뉴 4를 눌렀습니다"

        }
        return super.onOptionsItemSelected(item)
    }

}
