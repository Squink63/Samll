package com.padcmyanmar.abbc.project5.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.padcmyanmar.abbc.project5.R
import com.padcmyanmar.abbc.project5.adapters.BottomNavigationViewPagerAdapter
import kotlinx.android.synthetic.main.activity_bottom_navigation_with_view_pager.*

class BottomNavigationWithViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation_with_view_pager)

        val bottomNavViewPagerAdapter = BottomNavigationViewPagerAdapter(this)
        viewPager.adapter = bottomNavViewPagerAdapter
        viewPager.currentItem = 0

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> bottomNavigation.selectedItemId = R.id.action_home
                    1 -> bottomNavigation.selectedItemId = R.id.action_notifications
                    2 -> bottomNavigation.selectedItemId = R.id.action_profile
                }
            }
        })

        bottomNavigation.setOnNavigationItemSelectedListener { menuItem : MenuItem ->
            when(menuItem.itemId){
                R.id.action_home -> {
                viewPager.currentItem = 0
                true
                }
                R.id.action_notifications  -> {
                    viewPager.currentItem = 1
                    true
                }
                R.id.action_profile -> {
                    viewPager.currentItem = 2
                    true
                }
                else -> false
            }

        }
    }
}