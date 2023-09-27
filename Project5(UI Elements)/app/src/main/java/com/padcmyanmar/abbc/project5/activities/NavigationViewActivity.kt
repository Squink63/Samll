package com.padcmyanmar.abbc.project5.activities

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.padcmyanmar.abbc.project5.R
import kotlinx.android.synthetic.main.activity_navigation_view.*

class NavigationViewActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_view)

        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.white))

        val toogle = ActionBarDrawerToggle(
            this,
                drawerLayout,
                toolbar,
            R.string.drawer_open,
            R.string.drawer_close

        )

        toogle.syncState()

        navView.setNavigationItemSelectedListener  (this)

        //SwipeRefresh
        btnEnd.setOnClickListener {
            swfMain.isRefreshing = false
        }
    }

    //Back
    override fun onBackPressed() {
        when {
            drawerLayout.isDrawerOpen(GravityCompat.START) -> {
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            else -> {
                super.onBackPressed()
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_import -> {
                Toast.makeText(this,"This is Camera", Toast.LENGTH_LONG).show()
                //To close drawer
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            R.id.nav_favorite ->
                Toast.makeText(this,"Your Favorites", Toast.LENGTH_LONG).show()

            R.id.nav_recent ->
                Toast.makeText(this,"This is Recent", Toast.LENGTH_LONG).show()

            R.id.nav_trash ->
                Toast.makeText(this,"This is Trash", Toast.LENGTH_LONG).show()

        }
        return true
    }
}