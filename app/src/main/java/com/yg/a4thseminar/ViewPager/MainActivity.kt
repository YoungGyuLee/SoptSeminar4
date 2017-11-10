package com.yg.a4thseminar.ViewPager

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import com.yg.a4thseminar.R
import com.yg.a4thseminar.TabAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_tab.addTab(main_tab.newTab().setText("1번 탭"))
        main_tab.addTab(main_tab.newTab().setText("2번 탭"))
        main_tab.addTab(main_tab.newTab().setText("3번 탭"))

        var tabAdapter = TabAdapter(supportFragmentManager, main_tab.tabCount)

        main_viewpager.adapter = tabAdapter

        main_viewpager.currentItem = 0
        main_title_text.text = "피카츄 프래그먼트"
        main_viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(main_tab))

        main_tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabSelected(tab: TabLayout.Tab?) {
                main_viewpager.currentItem = tab!!.position
                when(tab!!.position){
                    0 ->{
                        main_title_text.text = "피카츄 프래그먼트"
                    }
                    1->{
                        main_title_text.text = "이상해씨 프래그먼트"
                    }
                    2->{
                        main_title_text.text = "파이리 프래그먼트"
                    }
                }
            }
        })
    }
}
