package com.padcmyanmar.abbc.project1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity:AppCompatActivity() {

    private val IMAGE_REQUEST_CODE = 100

    companion object{
        val IE_DATA_TO_SHOW = "DATA TO SHOW"
        val IE_DATA_TO_RETURN = "DATA TO RETURN"

        fun newIntent(context: Context): Intent{
            return Intent(context,SecondActivity::class.java)
        }

        fun newIntent(context: Context,dataToShow:String):Intent{
            val intent = Intent(context,SecondActivity::class.java)
                .putExtra(IE_DATA_TO_SHOW,dataToShow)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val dataMessage = intent.getStringExtra(IE_DATA_TO_SHOW)
        tvMessage.text = dataMessage

        btnChooseImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent,IMAGE_REQUEST_CODE)
        }

        btnOpenYoutube.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://youtube.com"))
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            val intent = Intent()
            intent.putExtra(IE_DATA_TO_RETURN,"Fine!Thank you and you?")
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data?.data != null){
            val image = data.data
            ivSelectedImage.setImageURI(image)
        }
    }
}