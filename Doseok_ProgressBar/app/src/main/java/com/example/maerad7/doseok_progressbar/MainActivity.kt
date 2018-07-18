package com.example.maerad7.doseok_progressbar

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener{

            //프로그레스바 사라졋다가 생겻다가
            progressBar1.visibility= View.VISIBLE
        }
        button2.setOnClickListener{
            var i = 0

            object : AsyncTask<Void,Void,Void>(){
                override fun doInBackground(vararg p0: Void?): Void? {
                    while(i<= 100){
                        progressBar2.setProgress(i)
                        i=i+1
                        Thread.sleep(300)
                    }
                    return null
                }

            }.execute()
        }
    }
}
