package com.example.maerad7.doseokcontextmenu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data = arrayOf("리스트1","리스트2","리스트3","리스트4","리스트5")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,data)
        listview.adapter = adapter

        registerForContextMenu(textView)
        registerForContextMenu(listview)

        listview.setOnItemClickListener { adapterView, view, i, l ->
            textView.text = "${i} 번째 항목을 터치했습니다."
        }
    }
    //v -> 사용자가 길게누른 객체가 들어온다 menuinfo안에 position이 들어있다.
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        when(v?.id){
            R.id.textView -> {
                menu?.setHeaderTitle("텍스트뷰의 메뉴")
                menuInflater.inflate(R.menu.textview_menu, menu)
            }
            R.id.listview -> {
                    menu?.setHeaderTitle("리스트뷰의 메뉴")
                    menuInflater.inflate(R.menu.listview_menu,menu)
                    var info = menuInfo as AdapterView.AdapterContextMenuInfo

                if(info.position%2 ==0){
                        menu?.add(Menu.NONE,Menu.FIRST+100,Menu.NONE,"리스트뷰 메뉴3")
                    }
                }
            }

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    //항목을 선택했을때 호출
    override fun onContextItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.textview_item1 -> textView.text="텍스트뷰의 컨텍스트 메뉴1"
            R.id.textview_item2 -> textView.text="텍스트뷰의 컨텍스트 메뉴2"
            R.id.listview_item1 ->{
                textView.text="텍스트뷰의 컨텍스트 메뉴1\n"

                var info = item?.menuInfo as AdapterView.AdapterContextMenuInfo
                textView.append("${info.position} 번째 항목")
            }
            R.id.listview_item2 -> {
                textView.text="텍스트뷰의 컨텍스트 메뉴2\n"

                var info = item?.menuInfo as AdapterView.AdapterContextMenuInfo
                 textView.append("${info.position} 번째 항목")
            }
        }
        return super.onContextItemSelected(item)
    }
}
