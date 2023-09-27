package com.padcmyanmar.abbc.project7.workmanager

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.work.Worker
import androidx.work.WorkerParameters

class DownloadWorker(private val context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {

        try {
            val request = DownloadManager.Request(Uri.parse("https://www.southernliving.com/thmb/EmvwuozrEjqzpPVRhY5PnLz1vuE=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-1348072128-8af35c603a394f1db3bfe59e37f5357c.jpg"))
            request.apply {
                setTitle("Download Image")
                setDescription("Downloading")
                setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "downloadImage")

                val downloadManager : DownloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                downloadManager.enqueue(request)
            }
            return Result.success()
        } catch (e : Exception){
            return Result.failure()
        }

    }
}