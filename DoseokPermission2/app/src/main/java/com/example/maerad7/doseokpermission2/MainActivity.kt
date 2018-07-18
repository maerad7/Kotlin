package com.example.maerad7.doseokpermission2

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var permission_list=arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.SEND_SMS,
            Manifest.permission.RECEIVE_SMS)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()
    }

    //퍼미션 체크
    fun checkPermission(){
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return
        }
            for(permission: String in permission_list){
                var check = checkCallingOrSelfPermission(permission)

                //허가되지 않은 퍼미션만 다시 권한을 받을지 물어본다
                if(check == PackageManager.PERMISSION_DENIED){
                    requestPermissions(permission_list,0)
                    break;
                }
            }

    }
    //권한을 물어보는 창이 사라진다음 호출, permissions = 권한들이 있는 배열 . grantResults= 해당권한이 허용여부
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        var i = 0

        //indices 하면 인덱스 번호가 i에 들어간다.
        for ( i in grantResults.indices){
            if(grantResults[i]== PackageManager.PERMISSION_GRANTED){
              textView.append("${permission_list[i]}:허용함\n")
            }else{
            textView.append("${permission_list[i]}:허용하지 않음\n")
             }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
