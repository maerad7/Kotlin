package com.example.maerad7.doseokfragment2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var first = FirstFragment()
    var second = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button6.setOnClickListener { view ->
            var tran = supportFragmentManager.beginTransaction()
            //tran.add(R.id.container,first)
            tran.replace(R.id.container,first)
            //백버튼 누르면 프래그먼트 종료
            tran.addToBackStack(null)
            tran.commit()
        }

        button7.setOnClickListener { view ->
            var tran = supportFragmentManager.beginTransaction()
            //tran.add(R.id.container,second)
            tran.replace(R.id.container,second)
            tran.addToBackStack(null)
            tran.commit()
        }
    }
}
