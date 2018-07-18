package com.example.maerad7.doseokwindowmanger

import android.content.Intent
import android.graphics.PixelFormat
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.support.annotation.RequiresApi
import android.view.View
import android.view.ViewDebug
import android.view.WindowManager
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var overlayView: View? = null
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //윈도우 권한이 있을 경우
        if (Settings.canDrawOverlays(this)) {
            overlayView = layoutInflater.inflate(R.layout.overlay, null)

            //오버레이의 텍스트 뷰 바꾸기
            var messageTextView = overlayView!!.findViewById<TextView>(R.id.textView_overay)
            messageTextView.setText("안녕?")

            var layout_flag: Int
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                layout_flag = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            } else {
                layout_flag = WindowManager.LayoutParams.TYPE_PHONE
            }

            var params = WindowManager.LayoutParams(
                    //가로
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    //세로
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    //x,y
                    0, 0,
                    layout_flag,
                    //속성
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    //투명
                    PixelFormat.TRANSLUCENT
            )
            windowManager.addView(overlayView, params)
            overlayView!!.setOnClickListener{

                //윈도우창 종료
                windowManager.removeView(overlayView)

                //종료후 액티비티 이동
                var intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
        //윈도우 권한이 없을 경우
        else {
            var intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + packageName))
            startActivityForResult(intent, 0)



        }

    }
}
