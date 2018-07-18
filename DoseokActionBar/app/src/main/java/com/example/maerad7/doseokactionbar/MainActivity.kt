package com.example.maerad7.doseokactionbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //메뉴 생성
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)

        // 서치뷰 아이디가져오기
        var search_item : MenuItem? = menu?.findItem(R.id.item5)
        var search_view : SearchView =  search_item?.actionView as SearchView

        //서치뷰 옵션 설정
        search_view.queryHint="검색"
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            //입력이 완료되면 호출 p0->new text 리턴 트루로하면 확인눌렀렀을 때 키보드 안내려감
            override fun onQueryTextSubmit(p0: String?): Boolean {
                textView2.text=p0
                return false
            }
            //입력 될때마다 호출 p0-> query
            override fun onQueryTextChange(p0: String?): Boolean {
                textView.text = p0
                return false
            }

        })
        return true
    }

    //메뉴 선택하면 호출
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.item1 -> textView.text="메뉴1"
            R.id.item2 -> textView.text="메뉴2"
            R.id.item3 -> textView.text="메뉴3"
            R.id.item4 -> textView.text="메뉴4"

        }
        return super.onOptionsItemSelected(item)
    }
}
