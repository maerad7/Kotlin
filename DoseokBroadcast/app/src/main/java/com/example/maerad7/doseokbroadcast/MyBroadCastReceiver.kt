package com.example.maerad7.doseokbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        when(p1!!.action){
            //부팅이 완료됬을때
            Intent.ACTION_BOOT_COMPLETED -> p0!!.startActivity(Intent(p0,MainActivity::class.java))
            Intent.ACTION_BATTERY_LOW -> Toast.makeText(p0,"배터리가 없습니다.",Toast.LENGTH_LONG).show()
            "android.net.conn.CONNECTIVITY_CHANGE" -> Toast.makeText(p0,"네트워크 상태가 변경 되었습니다.",Toast.LENGTH_LONG).show()
            "android.provider.Telephony.SMS_RECEIVED" -> Toast.makeText(p0,"문자가 도착했습니다.",Toast.LENGTH_LONG).show()
            Intent.ACTION_CAMERA_BUTTON -> Toast.makeText(p0,"카메라 버튼을 클릭 하였니다.",Toast.LENGTH_LONG).show()
            Intent.ACTION_SHUTDOWN -> Toast.makeText(p0,"디바이스가 종료 되었습니다.",Toast.LENGTH_LONG).show()
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> Toast.makeText(p0,"비행기 모드로 전환되었습니다.",Toast.LENGTH_LONG).show()
            Intent.ACTION_DATE_CHANGED -> Toast.makeText(p0,"날짜가 변경 되었습니다.",Toast.LENGTH_LONG).show()
            Intent.ACTION_TIME_TICK -> Toast.makeText(p0,"분이 변경 되었습니다.",Toast.LENGTH_LONG).show()
        }
    }
}
