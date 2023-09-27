package com.padcmyanmar.abbc.project6.activities

import android.content.ClipData.newIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.abbc.project6.R
import com.padcmyanmar.abbc.project6.adapter.NewsAdapter
import com.padcmyanmar.abbc.project6.delegate.NewsItemActionDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsItemActionDelegate {

    private lateinit var adapter : NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = NewsAdapter(this)
        rvNews.adapter = adapter
        rvNews.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
//        rvNews.layoutManager = GridLayoutManager(this,2)

        faBtn1.setOnClickListener {
            val intent = Intent(this,ActivityWithViewPagerCustomView::class.java)
            startActivity(intent)
        }
    }

    override fun onTapNews() {
        startActivity(NewsDetailActivity.newIntent(this))
    }
}