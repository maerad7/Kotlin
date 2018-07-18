package com.example.maerad7.doseokspinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var countries =arrayOf("한국","미국")
    var city_korea = arrayOf("서울","부산")
    var city_USA = arrayOf("뉴욕","워싱턴")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //스피너에 컨트리 어댑터를 연결( 3번째 파라미러가 데이터 값)
        var countryAdapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,countries)
        spinner_country.adapter=countryAdapter

        spinner_country.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
            //spinner 1번에서 선택하여 연결된 부가정보가 있는 spinner
            //p0 -> 아이템 정보가 있는 객체 p1-> position
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var country = p0!!.getItemAtPosition(p2)
                if(country == "한국"){
                    var adapter = ArrayAdapter<String>(this@MainActivity,android.R.layout.simple_spinner_dropdown_item,city_korea)
                    spinner_city.adapter = adapter

                }else if(country == "미국"){
                    var adapter = ArrayAdapter<String>(this@MainActivity,android.R.layout.simple_spinner_dropdown_item,city_USA)
                    spinner_city.adapter = adapter
                }
            }
        }
        spinner_city.onItemSelectedListener= object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var country = p0!!.getItemAtPosition(p2).toString()
                Toast.makeText(this@MainActivity,country+"를 선택하셨습니다.",Toast.LENGTH_SHORT).show()
            }

        }
    }
}
