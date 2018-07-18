package com.example.maerad7.doseoklistdialog

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var data = arrayOf("항목1","항목2","항목3","항목4","항목5")
    var data2 = arrayOf("토고","프랑스","스위스","스페인","일본","독일","브라질","대한민국")
    var data3 = intArrayOf(R.drawable.imgflag1,R.drawable.imgflag2,R.drawable.imgflag3,R.drawable.imgflag4,R.drawable.imgflag5,R.drawable.imgflag6
            ,R.drawable.imgflag7,R.drawable.imgflag8)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //기본 리스트 다이어로그
        button.setOnClickListener { view ->
            var builder = AlertDialog.Builder(this)
            builder.setTitle("리스트 다이얼로그")
            builder.setNegativeButton("취소",null)

            var listner = object:DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    textView.text="기본 리스트 다이이어로그 : ${data[p1]}"
                }

            }
            builder.setItems(data,listner)
            builder.show()
        }

        //커스텀 리스트 다이어로그
        button2.setOnClickListener { view ->
            var builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀리스트 다이얼로그")

            //리스트 만들고 리스트에 데이터 넣기
            var list =ArrayList<HashMap<String,Any>>()

            var i = 0
            while(i<data2.size){
                var map = HashMap<String,Any>()
                map.put("data2",data2[i])
                map.put("data3",data3[i])

                list.add(map)
                i++
            }


            var keys = arrayOf("data2","data3")
            var ids = intArrayOf(R.id.textView2,R.id.imageView)

            //어탭더 만들기
            var adapter =SimpleAdapter(this,list,R.layout.customdialog,keys,ids)

            //리스너 만들기
            var listner = object: DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    textView.text="커스텀 리스트 다이얼로그 : ${data2[p1]}"
                }

            }
            builder.setAdapter(adapter,listner)

            builder.setNegativeButton("취소",null)
            builder.show()
        }
    }


}
