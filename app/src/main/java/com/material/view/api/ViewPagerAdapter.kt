package com.material.view.api

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

private const val EARTH_FRAGMENT = 0
private const val MARS_FRAGMENT = 1
private const val SYSTEM_FRAGMENT = 2

class ViewPagerAdapter(private  val fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    val fragments = arrayOf(EarthFragment(),MarsFragment(),SystemFragment())

    override fun getCount()= fragments.size

    override fun getItem(position: Int): Fragment {
        return when(position){
            EARTH_FRAGMENT ->fragments[EARTH_FRAGMENT]
            MARS_FRAGMENT ->fragments[MARS_FRAGMENT ]
            SYSTEM_FRAGMENT ->fragments[SYSTEM_FRAGMENT]
            else -> fragments[EARTH_FRAGMENT]
        }
    }

    /*
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            EARTH_FRAGMENT ->"EARTH"
            MARS_FRAGMENT ->"MARS"
            SYSTEM_FRAGMENT ->"SYSTEM"
            else -> "EARTH"
        }
    }
    */

} 