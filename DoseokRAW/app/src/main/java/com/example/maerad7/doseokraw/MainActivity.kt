package com.example.maerad7.doseokraw

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner.setOnTouchListener { view, motionEvent ->
            if(motionEvent.action == MotionEvent.ACTION_DOWN){
                var sound = MediaPlayer.create(this,R.raw.effect_sound)
                sound.start()
            }
            false

        }



    }
}
