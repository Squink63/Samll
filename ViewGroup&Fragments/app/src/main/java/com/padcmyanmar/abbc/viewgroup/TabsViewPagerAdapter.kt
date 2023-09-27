package com.padcmyanmar.abbc.viewgroup

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.padcmyanmar.abbc.viewgroup.HomeFragment.Companion.KEY_HOME_DESCRIPTION
import com.padcmyanmar.abbc.viewgroup.ShortsFragment.Companion.KEY_SHORTS_DESCRIPTION
import com.padcmyanmar.abbc.viewgroup.SubscriptionFragment.Companion.KEY_SUBSCRIPTION_DESCRIPTION

class TabsViewPagerAdapter(fragmentActivity: FragmentActivity) :FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                val homeFragment = HomeFragment()

                // Pass Data
                val bundle =Bundle()
                bundle.putString(KEY_HOME_DESCRIPTION, "This is Home Fragment")
                homeFragment.arguments = bundle
                return homeFragment
            }
            1 -> {
                val shortsFragment = ShortsFragment()

                //Pass Data
                val bundle = Bundle().apply {
                    this.putString(KEY_SHORTS_DESCRIPTION, "This is Shorts Fragment")
                }
                shortsFragment.arguments = bundle
                return shortsFragment
            }
            else -> {
                val subscriptionFragment = SubscriptionFragment()

                //Pass data
                val bundle = Bundle().apply {
                    this.putString(KEY_SUBSCRIPTION_DESCRIPTION, "This is Subscription Fragment")
                }
                subscriptionFragment.arguments = bundle
                return subscriptionFragment
            }
        }
    }
}