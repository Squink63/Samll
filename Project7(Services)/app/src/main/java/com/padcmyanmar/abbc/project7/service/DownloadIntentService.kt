package com.padcmyanmar.abbc.project7.service

import android.app.DownloadManager
import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.widget.Toast
import java.io.File

const val SERVICE_NAME = "Download"

class DownloadIntentService : IntentService(SERVICE_NAME) {

    override fun onHandleIntent(intent: Intent?) {
        val imagePath = intent?.getStringExtra("image_path")

        if (imagePath != null) {
            downloadImage(imagePath)
        }
        else {
            Log.d("Missing Image Path", "Stopping Service")
            stopSelf()
        }

    }


    private fun downloadImage(imagePath: String) {
        downloadImageNew(downloadUrlOfImage = imagePath)

    }

    override fun onDestroy() {
        Toast.makeText(this, "Stopping Service", Toast.LENGTH_LONG).show()
        super.onDestroy()
    }

    private fun downloadImageNew(filename: String = "${System.currentTimeMillis()}.jpg", downloadUrlOfImage: String) {
        try {
            val dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            val downloadUri: Uri = Uri.parse(downloadUrlOfImage)
            val request = DownloadManager.Request(downloadUri)
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
                .setAllowedOverRoaming(false)
                .setTitle(filename)
                .setMimeType("image/jpeg")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setDestinationInExternalPublicDir(
                    Environment.DIRECTORY_PICTURES, File.separator + filename
                )
            dm.enqueue(request)
            Toast.makeText(this, "Image download started.", Toast.LENGTH_SHORT).show()
        }
        catch (e: Exception) {
            Toast.makeText(this, "Image download failed.", Toast.LENGTH_SHORT).show()
        }
    }
}