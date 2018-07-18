package com.example.maerad7.doseokfragmentlifecycle

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MyFragment:Fragment(){
    //시작할때
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.myfragment,container,false)
        return view
    }
    //프레그먼트가 뷰에 나타나기 전에
    override fun onStart() {
        super.onStart()
    }
    //프레그먼트가 뷰에 나타난 상태
    override fun onResume() {
        super.onResume()
    }
    //프레그먼트 반만 가려진상태
    override fun onPause() {
        super.onPause()
    }
    //프레그먼트 정지
    override fun onStop() {
        super.onStop()
    }
    //프레그먼트 제거
    override fun onDetach() {
        super.onDetach()
    }
}