package com.wezz.monitoriaucb.view

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.yourpackagename.R

class VideosActivity : AppCompatActivity() {

    private lateinit var videoView1: VideoView
    private lateinit var videoView2: VideoView
    private lateinit var videoView3: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videos) // Certifique-se de que este é o layout correto

        initVideoViews()
    }

    private fun initVideoViews() {
        videoView1 = findViewById(R.id.videoView1)
        videoView2 = findViewById(R.id.videoView2)
        videoView3 = findViewById(R.id.videoView3)

        setVideoView(videoView1, R.raw.vid1)
        setVideoView(videoView2, R.raw.vid2)
        setVideoView(videoView3, R.raw.vid3)
    }

    private fun setVideoView(videoView: VideoView, videoResId: Int) {
        val uri = Uri.parse("android.resource://$packageName/$videoResId")
        videoView.setVideoURI(uri)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
    }
}
