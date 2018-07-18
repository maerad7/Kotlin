package com.example.maerad7.twolinelistview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data1=arrayOf("문자열1","문자열2","문자열3","문자열4","문자열5","문자열6")
    var data2=arrayOf("string1","string2","string3","string4","string5","string6")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list = ArrayList<HashMap<String,String>>()

        var i = 0
        while(i < data1.size){
            var map = HashMap<String,String>()
            map.put("str1",data1[i])
            map.put("str2",data2[i])
            list.add(map)

            i++
        }
        var key = arrayOf("str1","str2")
        var ids = intArrayOf(android.R.id.text1,android.R.id.text2)
        var adapter = SimpleAdapter(this,list,android.R.layout.simple_list_item_2,key,ids)
        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            textView2.text = data1[i]
        }
    }
}
