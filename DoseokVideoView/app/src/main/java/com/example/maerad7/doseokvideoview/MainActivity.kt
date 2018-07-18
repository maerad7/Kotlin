package com.example.maerad7.doseokvideoview

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //액션바 감추기
        supportActionBar!!.hide()

        //비디오뷰 시작하기
        var url = Uri.parse("https://www.rmp-streaming.com/media/bbb-360p.mp4")
        videoView.setVideoURI(url)
        videoView.start()

        //컨트롤러 만들기
        var controller = MediaController(this)
        videoView.setMediaController(controller)

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        //statusbar 사라지게 하기
        window.decorView.systemUiVisibility=(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }
}
