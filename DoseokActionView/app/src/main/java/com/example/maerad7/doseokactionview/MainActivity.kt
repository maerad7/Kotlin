package com.example.maerad7.doseokactionview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var searchView:SearchView? = null
    var data_list =arrayOf("aaa","bbb","ccc","aabb","ccdd")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adpater = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data_list)
        list1.adapter = adpater

        //글자 검색기능
        list1.isTextFilterEnabled=true

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        //아이템 가져오기
        var item = menu?.findItem(R.id.item1)
        var listner= ActionListner()
        item?.setOnActionExpandListener(listner)

        //아이템안의 서치뷰 가져오기
        searchView = item?.actionView as SearchView
        searchView?.queryHint = "입력해주세요"
        var listner2 = ActionListner2()
        searchView?.setOnQueryTextListener(listner2)

        return true
    }

    inner class ActionListner : MenuItem.OnActionExpandListener {
        //펼쳤을때
        override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
           textView.text="펼쳤을때"
            return true
        }
        //접혔을때
        override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
            textView.text= " 접혔을때"
            return true

        }
    }

    inner class ActionListner2 : SearchView.OnQueryTextListener {
        //키보드의 확인 버튼을 눌렀을때
        override fun onQueryTextSubmit(p0: String?): Boolean {
            textView2.text="엔터키 : ${p0}"
            //입력후 키보드 내림
            searchView?.clearFocus()
            return true
        }
        //입력할때
        override fun onQueryTextChange(p0: String?): Boolean {
            textView2.text = p0
            //입력문자 검색기능
            list1.setFilterText(p0)
            //입력한 글자 지우면 원상태로 복귀
            if(p0?.length == 0){
                list1.clearTextFilter()
            }

            return true
        }
    }
}
