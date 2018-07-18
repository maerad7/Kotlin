package com.example.maerad7.doseokservice

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.os.SystemClock
import android.util.Log

//인텐트 서비스


// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "com.example.maerad7.doseokservice.action.FOO"
private const val ACTION_BAZ = "com.example.maerad7.doseokservice.action.BAZ"

// TODO: Rename parameters
private const val EXTRA_PARAM1 = "com.example.maerad7.doseokservice.extra.PARAM1"
private const val EXTRA_PARAM2 = "com.example.maerad7.doseokservice.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class ServiceClass2 : IntentService("ServiceClass2") {

    //서비스가 동작하면 호출
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }
    //쓰레드 intentServcie
    override fun onHandleIntent(intent: Intent?) {
        var idx=0
        while(idx<10){
            SystemClock.sleep(1000)
            var time = System.currentTimeMillis()
            Log.d("test1","Intent Servcie Running : ${time}")
            idx++
        }
    }

}
