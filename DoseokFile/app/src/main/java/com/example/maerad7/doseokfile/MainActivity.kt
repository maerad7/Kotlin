package com.example.maerad7.doseokfile

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*


class MainActivity : AppCompatActivity() {
    var permission_list = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
    var path:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 외부저장소 경로구하기
        path = Environment.getExternalStorageDirectory().absolutePath + "/android/data" + packageName
        checkPermission()

        //파일 객체에 파일경로 넣고 경로 없으면 디렉토리 생성
        var file = File(path)
        if(file.exists() == false){
            file.mkdir()
        }

        //내부저장소 저장
        button.setOnClickListener { view ->
            try {
                //MODE_PRIVATE -> 파일 덮어쓰기
                var oupput = openFileOutput("myFile.dat", Context.MODE_PRIVATE)
                var dos = DataOutputStream(oupput)
                dos.writeInt(100)
                dos.writeDouble(11.11)
                dos.writeUTF("안녕하세요")
                dos.flush()
                dos.close()
                textView.text = "저장완료"
            }catch (e: Exception){
                e.printStackTrace()
            }
        }

        //내부저장소 읽기
        button2.setOnClickListener { view ->
            try{
            var input = openFileInput("myFile.dat")
            var dis = DataInputStream(input)
            var value1 = dis.readInt()
            var value2 = dis.readDouble()
            var value3 = dis.readUTF()
            dis.close()

            textView.text = "value1 : ${value1}\n"
            textView.append("value2 : ${value2}\n")
            textView.append("value3 : ${value3}")
        }catch (e: Exception){
            e.printStackTrace()}
        }

        //외부 저장소 저장
        button3.setOnClickListener { view ->
            try{
                var output = FileOutputStream(path + "/sdFile.dat")
                var dos = DataOutputStream(output)
                dos.writeInt(200)
                dos.writeDouble(22.22)
                dos.writeUTF("안녕하세요")
                dos.flush()
                dos.close()
                textView.text="외부저장소 저장완료"
            }catch(e:Exception){
                e.printStackTrace()
            }
        }

        //외부저장소 읽기
        button4.setOnClickListener { view ->
            try{
                var input = FileInputStream(path+"/sdFile.dat")
                var dis = DataInputStream(input)
                var value1 = dis.readInt()
                var value2 = dis.readDouble()
                var value3 = dis.readUTF()
                dis.close()

                textView.text = "value1 : ${value1}\n"
                textView.append("value2 : ${value2}\n")
                textView.append("value3 : ${value3}\n")
            }catch (e : Exception){
                e.printStackTrace()
            }
        }
    }
    //권한체크
    fun checkPermission(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return
        }
        for(permission in permission_list){
            var chk = checkCallingOrSelfPermission(permission)
            if(chk == PackageManager.PERMISSION_DENIED){
                requestPermissions((permission_list),0)
                break
            }
        }
    }
}
