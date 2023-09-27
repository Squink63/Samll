package com.padcmyanmar.abbc.project5.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.padcmyanmar.abbc.project5.fragments.HomeFragment
import com.padcmyanmar.abbc.project5.fragments.NotificationFragment
import com.padcmyanmar.abbc.project5.fragments.ProfileFragment

class BottomNavigationViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
       return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return HomeFragment()
            1  -> return NotificationFragment()
            2 -> return ProfileFragment()
        }
        return HomeFragment()
    }
}