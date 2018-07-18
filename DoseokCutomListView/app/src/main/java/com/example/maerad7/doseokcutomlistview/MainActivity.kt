package com.example.maerad7.doseokcutomlistview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var data = arrayOf("리스트1","리스트2","리스트3","리스트4","리스트5","리스트6","리스트7","리스트8","리스트9","리스트10","리스트11","리스트12")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,data)

        //커스텀일 경우에는 뷰의 id도 추가해줘야 된다.
       var adapter = ArrayAdapter(this,R.layout.raw1,R.id.textView2,data)
        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            textView.text=data[i]
        }
    }
}
