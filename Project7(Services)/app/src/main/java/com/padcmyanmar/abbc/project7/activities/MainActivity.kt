package com.padcmyanmar.abbc.project7.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.padcmyanmar.abbc.project7.R
import com.padcmyanmar.abbc.project7.service.DownloadIntentService
import com.padcmyanmar.abbc.project7.service.DownloadJobIntentService
import com.padcmyanmar.abbc.project7.service.ForegroundService
import com.padcmyanmar.abbc.project7.workmanager.DownloadWorker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnStartService.setOnClickListener {
            ForegroundService.startService(this,"Update available")
        }

        btnEndService.setOnClickListener {
            ForegroundService.stopService(this)
        }

        //Intent Service
        btnDownloadImage1.setOnClickListener {
            val intent = Intent (this, DownloadIntentService::class.java)
            intent.putExtra("image_path", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Pizza-3007395.jpg/800px-Pizza-3007395.jpg")
            startService(intent)
        }
        //Job Intent Service
        btnDownloadImage2.setOnClickListener {
            val intent = Intent(this, DownloadJobIntentService::class.java)
            intent.putExtra("image_path", "https://thecozycook.com/wp-content/uploads/2020/02/Copycat-McDonalds-French-Fries-.jpg")
            DownloadJobIntentService.startWork(this,intent)
        }


        //WorkManager
        btnWorkManager.setOnClickListener {

            //Constraints
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.NOT_ROAMING)
                .setRequiresBatteryNotLow(true)
                .setRequiresStorageNotLow(true)
                .build()

            //Work Request
            val downloadWorkRequest : WorkRequest =
                OneTimeWorkRequestBuilder<DownloadWorker>()
                    .setConstraints(constraints)
                    .build()

            //Enqueue Work Manager
            WorkManager
                .getInstance(this)
                .enqueue(downloadWorkRequest)


        }
    }
}