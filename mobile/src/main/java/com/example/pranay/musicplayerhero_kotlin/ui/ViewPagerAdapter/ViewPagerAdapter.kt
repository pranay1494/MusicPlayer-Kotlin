package com.example.pranay.musicplayerhero_kotlin.ui.ViewPagerAdapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 *
 */
class ViewPagerAdapter(supportFragmentManager: FragmentManager?) : FragmentPagerAdapter(supportFragmentManager) {

    val mFragList: MutableList<Fragment> = mutableListOf()
    val titles: MutableList<String> = mutableListOf()

    override fun getItem(position: Int): Fragment {
        return mFragList[position]
    }

    override fun getCount(): Int {
        return mFragList.size
    }

    fun addFragment(fragment: Fragment,title:String) {
        mFragList.add(fragment)
        titles.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles.get(position)
    }
}