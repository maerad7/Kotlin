package com.example.maerad7.doseokviewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.widget.TableLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //어댑터에서 인자로 supportFragmentManger 넣어야된다.
        doseok_viewPager.adapter=doseokViewPagerAdapter(supportFragmentManager)
        doseok_tablayout.addTab(doseok_tablayout.newTab().setText("Fragment1"))
        doseok_tablayout.addTab(doseok_tablayout.newTab().setText("Fragment2"))

        doseok_tablayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                doseok_viewPager.setCurrentItem(tab!!.position)
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

        })
        //드래그로 화면을 바꿀때 탭도 변경시키는 코드
        doseok_viewPager.addOnPageChangeListener(object:TabLayout.TabLayoutOnPageChangeListener(doseok_tablayout){})
    }
    class doseokViewPagerAdapter(fm:FragmentManager):FragmentStatePagerAdapter(fm){
        var fragments=arrayOf(Fragment1(),Fragment2())
        //페이지가 전환될때 화면 부분
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }
        //페이지 갯수를 새는 부분
        override fun getCount(): Int {
            return fragments.size
        }

    }
}
