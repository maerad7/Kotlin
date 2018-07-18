package com.example.maerad7.doseokrequestpermission

import android.Manifest
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calendar= Manifest.permission.READ_CALENDAR
        var camera=Manifest.permission.CAMERA
        var contact =Manifest.permission.READ_CONTACTS
        var location=Manifest.permission.ACCESS_FINE_LOCATION
        var microphone= Manifest.permission.RECORD_AUDIO
        var phone = Manifest.permission.READ_PHONE_STATE
        var sensor = Manifest.permission.BODY_SENSORS
        var sms = Manifest.permission.SEND_SMS
        var storage = Manifest.permission.READ_EXTERNAL_STORAGE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { //alt+enter
            requestPermissions(arrayOf(calendar,camera,contact,location,microphone,phone,sensor,sms,storage),100)
        }
    }
    //권한을 받았는지 안받았는지 체크, 권한이 없다면 알림메세지 띄움, permissions: 권한에대한 이름 . grantsResults : 권한을 받았는 안받았는지 알려주는 파라미터 허가(0),불허가(-1)
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==100){
            for (i in permissions.indices)
                println("권한 : "+ permissions[i]+"허가상태 :"+grantResults[i])
        }
    }
}
