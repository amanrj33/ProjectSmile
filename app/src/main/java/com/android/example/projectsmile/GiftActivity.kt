package com.android.example.projectsmile

import android.media.session.MediaController
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.android.example.projectsmile.databinding.ActivityGiftBinding
import java.net.URI

class GiftActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGiftBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoView = binding.videoView
        val mediaController =  android.widget.MediaController(this)
        mediaController.setAnchorView(videoView)

        //"android.resource://"+getPackageName()+"/"+R.raw.test
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(Uri.parse("android.resource://"+ packageName +"/"+R.raw.try1))
        videoView.requestFocus()
        videoView.start()
    }
}