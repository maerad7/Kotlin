package com.example.maerad7.doseokviewpager2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var view_list = ArrayList<View>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_list.add(layoutInflater.inflate(R.layout.view1,null))
        view_list.add(layoutInflater.inflate(R.layout.view2,null))
        view_list.add(layoutInflater.inflate(R.layout.view3,null))

        pager.adapter = CustomAdapter()

        pager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{


            override fun onPageScrollStateChanged(p0: Int) {

            }
            //p0 -> index
            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
                textView.text=p0.toString() + " 번째 뷰가 나타났습니다"
            }

            override fun onPageSelected(p0: Int) {
            }
        })
    }
    inner class CustomAdapter : PagerAdapter(){

        //현재 객체가 보여줄 객체와 일치하는지 view->보여줄 뷰 객체의 주소, any -> 객체가 넘어옴
        override fun isViewFromObject(p0: View, p1: Any): Boolean {
            return p0 == p1
        }
        //보여줄 뷰의 개수를 반환하는 메소드
        override fun getCount(): Int {
            return view_list.size
        }
        // 항목을 구성하기 위해 호출함
        override fun instantiateItem(container: ViewGroup, position: Int): Any {

            //isViewFromObject p0로
            pager.addView(view_list[position])
            //isViewFromObject p1으로
            return view_list[position]
        }

        //작동하지 않는 아이템 제거
        override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
            pager.removeView(obj as View)
        }

    }
}
