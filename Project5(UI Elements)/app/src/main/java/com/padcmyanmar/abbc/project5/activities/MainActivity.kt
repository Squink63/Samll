package com.padcmyanmar.abbc.project5.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import com.padcmyanmar.abbc.project5.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        switchFragment(HomeFragment())
//
//        bottomNavigation.setOnNavigationItemSelectedListener { menuItem : MenuItem ->
//            when(menuItem.itemId){
//                R.id.action_home -> {
//                    switchFragment(HomeFragment())
//                }
//                R.id.action_notifications -> {
//                    switchFragment(NotificationFragment())
//                }
//                R.id.action_profile -> {
//                    switchFragment(ProfileFragment())
//                }
//            }
//            false
//
//
//        }
//    }
//
//    private fun switchFragment(fragment : Fragment){
//        supportFragmentManager.beginTransaction()
//            .add(R.id.flContainer,fragment)
//            .commit()

        btnBottomNav.setOnClickListener {
           goTo(BottomNavigationWithViewPagerActivity())

        }

        btnAppBar.setOnClickListener {
            goTo(AppBarBottomActivity())

        }

        btnBottomSheet.setOnClickListener {
           goTo(BottomSheetActivity())

        }

        btnUiElement.setOnClickListener {
            goTo(OtherCommonUiElementActivity())

        }

        btnCollapsing.setOnClickListener {
            goTo(CollapsingToolbarActivity())

        }

        btnCoordinator.setOnClickListener {
            goTo(CoordinatorActivity())

        }

        btnDrawer.setOnClickListener {
            goTo(NavigationViewActivity())

        }

    }

    private fun goTo(activity: AppCompatActivity){
        val intent = Intent(this,activity::class.java)
        startActivity(intent)
    }

}