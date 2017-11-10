package com.yg.a4thseminar

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by 2yg on 2017. 11. 7..
 */
class TabAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    var tabCount : Int = 0
    var firtTab : FirstFragment? = null
    var secondTab : SecondFragment? = null
    var thirdTab : ThirdFragment? = null

    constructor(fm : FragmentManager?, tabCount : Int) : this(fm){
        this.tabCount = tabCount
        this.firtTab = FirstFragment()
        this.secondTab = SecondFragment()
        this.thirdTab = ThirdFragment()
    }

    override fun getItem(position: Int): Fragment? {
        when(position){
            0-> {
                val bundle = Bundle()
                bundle.putString("title", "피카츄")
                firtTab!!.arguments = bundle
                return firtTab
            }
            1-> {
                val bundle = Bundle()
                bundle.putString("title", "이상해씨")
                 secondTab!!.arguments = bundle
                return secondTab
            }
            2-> {
                val bundle = Bundle()
                bundle.putString("title", "파이리")
                thirdTab!!.arguments = bundle
                return thirdTab
            }
        }

        return null
    }

    override fun getCount(): Int = tabCount
}
