package com.example.maerad7.doseoksurfaceview

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),SurfaceHolder.Callback,MediaPlayer.OnPreparedListener {

    var surfaceHolder:SurfaceHolder? = null
    var mediaPlayer:MediaPlayer? = null



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        surfaceHolder= surfaceView.holder

        //this->SurfaceHolder.Callback 인터페이스를 가리킴
        surfaceHolder!!.addCallback(this)

        //뒤로가기 5초 전
        back.setOnClickListener {
            var position = mediaPlayer!!.currentPosition - 5000
            mediaPlayer!!.seekTo(position)
        }

        ///앞으로가기 5초 후
        fast.setOnClickListener {
            var position = mediaPlayer!!.currentPosition + 5000
            mediaPlayer!!.seekTo(position)
        }

        //정지
        stop.setOnClickListener {
            mediaPlayer!!.pause()
        }

        //시작
        start.setOnClickListener {
            mediaPlayer!!.start()
        }
    }
    //surface 안에 있는 데이터가 변경했을때 발생, ex) 다른영상으로 바뀌었을 때
    override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {
    }

    //surface뷰가 종료될때 사라질때 액티비티가 종료될때 호출
    override fun surfaceDestroyed(p0: SurfaceHolder?) {
    }

    //surface뷰가 생성될때 , 액티비티가 생성될때 , 영상이 만들어지기 직전 호출
    override fun surfaceCreated(p0: SurfaceHolder?) {
        var url = "https://www.rmp-streaming.com/media/bbb-360p.mp4"
        mediaPlayer = MediaPlayer()

        //mediapalyer와 surfaceview 연결
        mediaPlayer!!.setDisplay(p0)
        mediaPlayer!!.setDataSource(url)

        //영상 준비
        mediaPlayer!!.prepare()

        //this -> MediaPlayer.OnPreparedListener ->    override fun onPrepared(p0: MediaPlayer?)
        mediaPlayer!!.setOnPreparedListener(this)
    }

    //영상준비가 완료 됫을때
    override fun onPrepared(p0: MediaPlayer?) {
        mediaPlayer!!.start()
    }
}

