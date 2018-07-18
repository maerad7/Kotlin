package com.example.maerad7.doseokcustomlistview2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.*

class MainActivity : AppCompatActivity() {
    var imgRes= intArrayOf(R.drawable.imgflag1,R.drawable.imgflag2,R.drawable.imgflag3,R.drawable.imgflag4,R.drawable.imgflag5,R.drawable.imgflag6,
            R.drawable.imgflag7,R.drawable.imgflag8)
    var data1= arrayOf("토고","프랑스","스위스","스페인","일본","독일","브라질","대한민국")
    var data2 = arrayOf("togo","france","swiss","spain","japan","german","brazil","korea")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //여러 종류의 값을 넣을때 Any
        var list = ArrayList<HashMap<String,Any>>()

        var idx = 0
        while(idx < data1.size){
            var map = HashMap<String,Any>()

            map.put("flag",imgRes[idx])
            map.put("data1",data1[idx])
            map.put("data2",data2[idx])


            list.add(map)
            idx++
        }
        var key = arrayOf("flag","data1","data2")
        var ids = intArrayOf(R.id.imageView,R.id.textView,R.id.textView3)

        //context , 데이터, 레이아웃, 키값 , 뷰
        var adapter = SimpleAdapter(this,list,R.layout.row,key,ids)
        listView.adapter = adapter

        //해당 항목 누르면 이벤트 발생
       listView.setOnItemClickListener { adapterView, view, i, l ->
            textView2.text=data1[i]

        }

    }
}
