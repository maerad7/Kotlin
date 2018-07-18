package com.example.maerad7.doseokanimation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //글자 나타남
        button_fade_in.setOnClickListener{
            var anim = AnimationUtils.loadAnimation(this,R.anim.fade_in)
            textView_fade_in.visibility= View.VISIBLE
            textView_fade_in.startAnimation(anim)
        }
        //글자 사라짐
        button_fade_out.setOnClickListener {
            var anim = AnimationUtils.loadAnimation(this,R.anim.fade_out)
            textView_fade_in.visibility= View.INVISIBLE
            textView_fade_out.startAnimation(anim)

        }
        button_blink.setOnClickListener {
            var anim = AnimationUtils.loadAnimation(this,R.anim.blink)
            textView_blink.startAnimation(anim)
        }
        button_zoom_in.setOnClickListener{
            var anim= AnimationUtils.loadAnimation(this,R.anim.zoom_in)
            textView_zoom_in.startAnimation(anim)
        }
        button_zoom_out.setOnClickListener{
            var anim = AnimationUtils.loadAnimation(this,R.anim.zoom_out)
            textView_zoom_out.startAnimation(anim)
        }
        button_rotate.setOnClickListener{
            var anim= AnimationUtils.loadAnimation(this,R.anim.rotate)
            textView_rotate.startAnimation(anim)
        }
        button_move.setOnClickListener{
            var anim = AnimationUtils.loadAnimation(this,R.anim.move)
            textView_move.startAnimation(anim)
        }
        button_siide_up.setOnClickListener {
            var anim = AnimationUtils.loadAnimation(this,R.anim.slide_up)
            textView_slide_up.startAnimation(anim)
        }
        button_slide_down.setOnClickListener {
            var anim = AnimationUtils.loadAnimation(this,R.anim.slide_down)
            textView_slide_down.startAnimation(anim)
        }
        button_bounce.setOnClickListener {
            var anim = AnimationUtils.loadAnimation(this,R.anim.bounce)
            bounce.startAnimation(anim)
        }
    }
}
