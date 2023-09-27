package com.padcmyanmar.abbc.project1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity: AppCompatActivity() {

    companion object {
        val IE_DATA_TO_RETURN = "DATA TO RETURN"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        btnClickMe.setOnClickListener{
////            Toast.makeText(this,"Welcome from PADC",Toast.LENGTH_SHORT).show()
//            val intent = Intent(this,SecondActivity::class.java)
//            startActivity(intent)
//            startActivity(SecondActivity.newIntent(this))
//            startActivity(SecondActivity.newIntent(this,"Hello! How are you?"))
            startActivityForResult(SecondActivity.newIntent(this,"Hello! How are you?"),100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && data != null && resultCode == Activity.RESULT_OK){
            val dataReturn = data.getStringExtra(IE_DATA_TO_RETURN)
            textView.text = dataReturn
        }
    }
}