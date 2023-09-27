package com.padcmyanmar.abbc.project9.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.padcmyanmar.abbc.project9.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvHello.setOnClickListener {
            when(tvHello1.isSelected) {
                false -> { tvHello.setBackgroundResource(R.color.purple_200) }

                else -> {tvHello.setBackgroundResource(R.color.teal_200)}
            }
        }

        tvHello1.setOnClickListener {
            when(tvHello.isSelected) {
                false -> { tvHello1.setBackgroundResource(R.color.purple_200) }

                else -> {tvHello1.setBackgroundResource(R.color.teal_200)}
            }
        }


    }
}