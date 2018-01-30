package com.example.pranay.musicplayerhero_kotlin.ui.ViewPagerAdapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 *
 */
class ViewPagerAdapter(supportFragmentManager: FragmentManager?) : FragmentPagerAdapter(supportFragmentManager) {

    val mFragList: MutableList<Fragment> = mutableListOf()

    override fun getItem(position: Int): Fragment {
        return mFragList[position]
    }

    override fun getCount(): Int {
        return mFragList.size
    }

    fun addFragment(fragment: Fragment) {
        mFragList.add(fragment)
    }
}