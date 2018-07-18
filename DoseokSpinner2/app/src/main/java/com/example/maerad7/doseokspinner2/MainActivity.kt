package com.example.maerad7.doseokspinner2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var data1=arrayOf("스피너 1-1","스피너 1-2","스피너 1-3","스피너 1-4","스피너 1-5","스피너 1-6")
    var data2=arrayOf("스피너 2-1","스피너 2-2","스피너 2-3","스피너 2-4","스피너 2-5","스피너 2-6")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_1,data1)
        var adapter2 = ArrayAdapter(this,android.R.layout.simple_list_item_1,data2)

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter=adapter1
        spinner2.adapter=adapter2

        var listner = SpinnerListner()

        spinner.onItemSelectedListener= object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                textView.text = data1[p2]
            }

        }

        //해당 값 호출
        spinner2.onItemSelectedListener= object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                textView.text = data2[p2]
            }

        }

        //스피너값 가져오기
        button.setOnClickListener{
            view ->
            textView.text = data1[spinner.selectedItemPosition]+"\n"
            textView.append(data2[spinner2.selectedItemPosition])

        }
        /*
        spinner.onItemSelectedListener(listner)
        spinner2.onItemSelectedListener(listner)

*/    }
    inner class SpinnerListner : AdapterView.OnItemSelectedListener{
        //아무것도 선택하지 않았을때 호출
        override fun onNothingSelected(p0: AdapterView<*>?) {
        }
        //선택했을때 호출 p2-> index
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            textView.text = data1[p2]
        }

    }

}


