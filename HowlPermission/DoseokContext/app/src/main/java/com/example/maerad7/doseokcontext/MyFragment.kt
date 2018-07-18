package com.example.maerad7.doseokcontext

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class MyFragment:Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.myfragment,container,false)
        //부모 액티비티의 컨텍스트를 받아온다
        Toast.makeText(activity,"프레그먼트 토스트메세지", Toast.LENGTH_LONG).show()
        return view

    }
}