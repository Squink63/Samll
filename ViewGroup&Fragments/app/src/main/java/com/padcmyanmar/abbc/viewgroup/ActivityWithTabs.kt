package com.padcmyanmar.abbc.viewgroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_with_tabs.*

class ActivityWithTabs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_tabs)

        //ViewPager
        val tabsViewPagerAdapter = TabsViewPagerAdapter(this)
        viewPagerTabs.adapter = tabsViewPagerAdapter

        //Tab Layout
        TabLayoutMediator(tabLayoutDifferentScreens, viewPagerTabs) { tab, position ->
            when(position){
                0 ->
                    tab.text ="Home"

                1 ->
                    tab.text = "Shorts"

                else ->
                    tab.text = "Subscriptions"

            }

        }.attach()
    }
}