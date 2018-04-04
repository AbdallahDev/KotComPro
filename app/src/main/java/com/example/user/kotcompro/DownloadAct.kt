package com.example.user.kotcompro

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_download.*

class DownloadAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)

        button5.setOnClickListener {

            var url=Uri.parse("http://sdkas.com/logo.gif")
            var manager=getSystemService(Context.DOWNLOAD_SERVICE)
                         as DownloadManager

            var request=DownloadManager.Request(url)
            request.setTitle("Test")
            request.setDescription("Please Wait...")
            request.setDestinationInExternalFilesDir(this,
                    Environment.DIRECTORY_DOWNLOADS,"logo.gif")
            
            manager.enqueue(request)

            Toast.makeText(this,"Download Complete",
                    Toast.LENGTH_LONG).show()
        }
    }
}
