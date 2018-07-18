package com.example.maerad7.doseoklocationmanger

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat

class MainActivity : AppCompatActivity(),LocationListener {
    override fun onLocationChanged(p0: Location?) {
        //위치 정보를 받아왔을때
        println(p0!!.latitude)
        println(p0!!.longitude)
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        //연결상태가 변경됬을 때
    }

    override fun onProviderEnabled(p0: String?) {
        //네트웍이나 gps에 연결 됬을때
    }

    override fun onProviderDisabled(p0: String?) {
        //연결이 끊어졌을때
    }

    var locationManager : LocationManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION),0)
        }

        locationManager=this.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    }
    fun getLoaction(){

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED&&
                (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED))

            //GPS로 연결이 됬으면
            if(locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)){

                //첫번째 어떤 방식으로 가져올건지,두번째 몇 밀리 세컨즈마다 갱신할건지,세번째 몇미터마다 위치 갱신할건지,4번째 무엇이랑 연결시킬것인가
                locationManager!!.requestLocationUpdates(LocationManager.GPS_PROVIDER,10000,100f,this)
            }else{
                locationManager!!.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,10000,100f,this)
            }

    }
    //퍼미션 받아오고 실행되는 코드
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 0){
            getLoaction()
        }
    }
}
