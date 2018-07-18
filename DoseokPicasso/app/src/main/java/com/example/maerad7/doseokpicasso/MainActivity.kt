package com.example.maerad7.doseokpicasso

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.adapter = MyRecyclerViewAdapter()
        recyclerview.layoutManager = GridLayoutManager(this,3)

    }
    inner class MyRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
            var imageview = ImageView(this@MainActivity)
            var params = LinearLayout.LayoutParams(p0!!.measuredWidth/3,p0!!.measuredHeight/3)
            imageview.layoutParams = params
            imageview.scaleType=ImageView.ScaleType.FIT_XY
            return CustomHolder(imageview)
        }

        inner class CustomHolder(imageview: ImageView) : RecyclerView.ViewHolder(imageview) {

        }

        override fun getItemCount(): Int {
            return Images().imageUrls.size
        }


        override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
            Picasso.get().load(Images().imageUrls[p1]).into(p0!!.itemView as ImageView)
        }

    }
}
