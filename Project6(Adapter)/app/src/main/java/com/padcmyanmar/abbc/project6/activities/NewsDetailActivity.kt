package com.padcmyanmar.abbc.project6.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.padcmyanmar.abbc.project6.R



class NewsDetailActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent{
            return Intent(context,NewsDetailActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

    }
}