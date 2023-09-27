package com.padcmyanmar.abbc.viewgroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import kotlinx.android.synthetic.main.activity_with_fragments.*

class ActivityWithFragments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_fragments)

//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragmentContainerFirst, SecondFragment())
//            .add(R.id.fragmentContainerSecond, FirstFragment())
//            .commit()

        supportFragmentManager.commit {
            add<SecondFragment>(R.id.fragmentContainerFirst)
            add<FirstFragment>(R.id.fragmentContainerSecond)
        }

        btnTab.setOnClickListener {
            val intent = Intent(this,ActivityWithTabs::class.java)
            startActivity(intent)
        }
    }
}