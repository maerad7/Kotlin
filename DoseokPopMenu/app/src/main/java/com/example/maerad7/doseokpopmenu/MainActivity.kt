package com.example.maerad7.doseokpopmenu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->

            //context, 뷰객체
            var pop = PopupMenu(this,textView)
            menuInflater.inflate(R.menu.popup_menu,pop.menu)
/*
            var listner = PopupListner()
            pop.setOnMenuItemClickListener(listner)*/

            pop.setOnMenuItemClickListener { menuItem ->
                when(menuItem.itemId){
                    R.id.item1->textView.text = "item1"
                    R.id.item2->textView.text = "item2"
                    R.id.item3->textView.text = "item3"
                }
                false
            }
            pop.show()


        }
    }
    inner class PopupListner : PopupMenu.OnMenuItemClickListener{
        //Menuitem 사용자가 터치한 객체
        override fun onMenuItemClick(p0: MenuItem?): Boolean {
            when(p0!!.itemId){
                R.id.item1->textView.text = "item1"
                R.id.item2->textView.text = "item2"
                R.id.item3->textView.text = "item3"

            }
            return false
        }


    }
}
