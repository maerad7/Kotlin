package com.example.maerad7.doseokactivitycontroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var input_fragment = InputFragmnet()
    var result_fragment = ResultFragment()
    var value1:String? = null
    var value2:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment("input")
    }

    //프래그먼트 교체를 담당, 프레그먼트는 담당하는 액티비티에 접근 가능
    fun setFragment(name:String){
        var tran= supportFragmentManager.beginTransaction()
        when(name){
            "input"->{
                tran.replace(R.id.container,input_fragment)
            }
            "result"->{
                tran.replace(R.id.container,result_fragment)
                tran.addToBackStack(null)
            }
        }
        tran.commit()
    }
}
