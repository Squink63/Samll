package com.padcmyanmar.abbc.project6.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.padcmyanmar.abbc.project6.R
import com.padcmyanmar.abbc.project6.adapter.ViewPagerWithCustomViewAdapter
import kotlinx.android.synthetic.main.activity_with_view_pager_custom_view.*

class ActivityWithViewPagerCustomView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_view_pager_custom_view)

        val viewPagerAdapter =ViewPagerWithCustomViewAdapter()
        viewPagerCustomView.adapter = viewPagerAdapter
    }
}