package com.example.maerad7.doseokcustomadapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var data1=arrayOf("데이터1","데이터2","데이터3","데이터4","데이터5","데이터6")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // var adapter = ArrayAdapter<String>(this,R.layout.row,R.id.textView2,data1)
        var adapter= ListAdapter()
        listView.adapter=adapter



    }
    inner class ListAdapter : BaseAdapter() {
        var listner = BtnListner()

        //p0 -> position
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
            var converView: View? = p1
            if (p1 == null) {
                converView = layoutInflater.inflate(R.layout.row, null)
            }
            var text: TextView? = converView?.findViewById<TextView>(R.id.textView2)
            var button1:Button? = converView?.findViewById<Button>(R.id.button1)
            var button2:Button? = converView?.findViewById<Button>(R.id.button2)

            text!!.text = data1[p0]

            button1!!.setOnClickListener(listner)
            button2!!.setOnClickListener(listner)

            //뷰에 해당 인덱스 저장, 뷰에서 호출가능
            button1.tag = p0
            button2.tag = p0






            return converView
        }


        //매개변수로 들어오면 객체를 반환
        override fun getItem(p0: Int): Any? {
            return null
        }
        //항목을 대표하는 아이디 값 반환
        override fun getItemId(p0: Int): Long {
            return 0
        }
        //리스트의 갯수 지정
        override fun getCount(): Int {
            return data1.size
        }

    }
    inner class BtnListner : View.OnClickListener{
        override fun onClick(p0: View?) {

            //저장덴 인덱스 호출
            var position = p0?.tag as Int
            when(p0!!.id){
                R.id.button1 -> textView.text = position.toString()+": 첫번째 버튼을 눌렀습니다\n"

                R.id.button2 -> textView.text = position.toString()+": 2번째 버튼을 눌렀습니다.\n"

            }
        }

    }
}
