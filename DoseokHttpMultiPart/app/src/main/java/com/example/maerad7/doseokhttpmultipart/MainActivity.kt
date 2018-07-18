package com.example.maerad7.doseokhttpmultipart

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.service.autofill.ImageTransformation
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONArray
import java.io.File
import java.io.IOException
import java.net.URL

class MainActivity : AppCompatActivity() {

    //서버에서 온 데이터를 listData에 저장
    var listData = ArrayList<HashMap<String,Any>>()
    //텍스트는 용량이적어 빠르게 받아옴, 그러나 이미지는 용량이커서 오래걸림
    //그래서 리스트뷰를 구성할 때 구성하고 필요한 이미지가 있을때 쓰레드를 스타트 시킴
    var imageMap = HashMap<String,Bitmap>()

    var permission_list = arrayOf(Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var adapter = ListAdapter()
        main_list.adapter = adapter

        //권한체크
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            requestPermissions(permission_list,0)
        }else{
            init()
        }


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        for(result in grantResults){
            if(result == PackageManager.PERMISSION_DENIED){
                return
            }
        }
        init()
    }
        fun init(){

            //파일 경로 가져오기
            var tempPath = Environment.getExternalStorageDirectory().absolutePath
            var dirPath = "${tempPath}/Android/data/${packageName}"

            //경로가 없으면 경로 만들기
            var file = File(dirPath)
            if(file.exists() == false){
                file.mkdir()
            }


//            var map1 = HashMap<String,Any>()
//            var map2 = HashMap<String,Any>()
//            var map3 = HashMap<String,Any>()
//
//            map1.put("mobile_img",android.R.drawable.alert_dark_frame)
//            map1.put("mobile_str1","항목1")
//            map2.put("mobile_img",android.R.drawable.ic_menu_agenda)
//            map2.put("mobile_str1","항목2")
//            map3.put("mobile_img",android.R.drawable.ic_menu_camera)
//            map3.put("mobile_str1","항목3")
//
//            listData.add(map1)
//            listData.add(map2)
//            listData.add(map3)

            var adapter = main_list.adapter as ListAdapter
            adapter.notifyDataSetChanged()
            //i -> position
            main_list.setOnItemClickListener { adapterView, view, i, l ->
                var detail_intent = Intent(this,DetailActivity::class.java)

                var map = listData.get(i) as HashMap<String,Any>
                var mobile_idx =map.get("mobile_idx") as Int
                detail_intent.putExtra("mobile_idx",mobile_idx)
                startActivity(detail_intent)
            }
        }



    //메뉴생성
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.maih_menu,menu)
        return true
    }

    //메뉴선택시 호출
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.menu_write -> {
                var write_intent = Intent(this,WriteActivity::class.java)
                startActivity(write_intent)

            }
            R.id.menu_reload -> {
                var thread = getDataThread()
                thread.start()
            }
        }
        return true
    }

    // 온 리쥼
    override fun onResume() {
        super.onResume()
        var thread = getDataThread()
        thread.start()
    }
    //어댑터 만들기
    inner class ListAdapter : BaseAdapter(){
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var convertView = p1
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.row,null)
            }

            var img1 = convertView?.findViewById<ImageView>(R.id.imageView)
            var str1 = convertView?.findViewById<TextView>(R.id.textView)

            var map = listData.get(p0)

            var mobile_img = map.get("mobile_img") as String
            var mobile_str1 = map.get("mobile_str1") as String

            var bitmap:Bitmap? = imageMap.get(mobile_img)
            if(bitmap == null){
                var thread2 = ImageNetworkThread(mobile_img as String)
                thread2.start()
            }else{
                img1?.setImageBitmap(bitmap)
            }

            //img1?.setImageResource(mobile_img)
            str1?.text = mobile_str1

            return convertView!!
        }

        override fun getItem(p0: Int): Any {
            return 0
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return listData.size
        }

    }
    //서버로부터 데이터 가져오는 쓰레드 생성
    inner class getDataThread : Thread(){
        override fun run() {
            var client = OkHttpClient()
            var builder = Request.Builder()
            var url = builder.url("http://192.168.0.3:8080/MobileServer/get_list.jsp")
            var request = url.build()
            var callback = Callback1()

            client.newCall(request).enqueue(callback)

        }
    }
    //데이터 가져오는 부분
    inner class Callback1 : Callback {
        override fun onFailure(call: Call?, e: IOException?) {

        }
        //서버로부터 응답 호출
        override fun onResponse(call: Call?, response: Response?) {
            var result = response?.body()?.string()

            listData.clear()

            var root = JSONArray(result)

            for(i in 0 until root.length()){
                var obj =root.getJSONObject(i)

                var mobile_idx = obj.getInt("mobile_idx")
                var mobile_img = obj.getString("mobile_img")
                var mobile_str1 = obj.getString("mobile_str1")

                var map = HashMap<String,Any>()
                map.put("mobile_idx",mobile_idx)
                map.put("mobile_img",mobile_img)
                map.put("mobile_str1",mobile_str1)

                listData.add(map)
            }
            runOnUiThread {
                var adapter = main_list.adapter as ListAdapter
                adapter.notifyDataSetChanged()
            }

        }
    }
    inner class ImageNetworkThread(var fileName:String) : Thread(){
        override fun run() {
            var url = URL("http://192.168.0.3:8080/MobileServer/upload/${fileName}")

            var connection = url.openConnection()
            var stream = connection.getInputStream()
            var bitmap = BitmapFactory.decodeStream(stream)

            imageMap.put(fileName,bitmap)

            runOnUiThread {
                var adapter = main_list.adapter as ListAdapter
                adapter.notifyDataSetChanged()
            }


        }
    }
}
