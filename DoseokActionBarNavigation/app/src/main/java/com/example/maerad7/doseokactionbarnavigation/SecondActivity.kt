package com.example.maerad7.doseokactionbarnavigation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //액션바 가져오기기
       var action = supportActionBar
        action?.setHomeButtonEnabled(true)
        action?.setDisplayHomeAsUpEnabled(true)
        action?.setHomeAsUpIndicator(android.R.drawable.ic_menu_directions)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            //백버튼 <-
            android.R.id.home->{
                finish()
            }
        }


        return super.onOptionsItemSelected(item)
    }

}
