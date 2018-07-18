package com.example.maerad7.doseokhttpmultipart

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_write.*
import okhttp3.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class WriteActivity : AppCompatActivity() {

    //이미지파일 저장할 경로
    var dirPath: String? = null
    //카메라를 찍어 이미지를 받아올 경로
    var contentUri: Uri? = null
    //사진을 회전시키고 나서 사이즈를 줄인 그이미지를 저장하여 또다시 저장시켜야하는데 이 경로를 사용함(썸네일)
    var pic_path: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        var tempPath = Environment.getExternalStorageDirectory().absolutePath
        dirPath = "${tempPath}/Android/data/${packageName}"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.write_menu, menu)
        return true
    }

    //메뉴 누르면 호출
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_camera -> {
                var camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                var fileName = "temp_${System.currentTimeMillis()}.jpg"
                var picPath = "${dirPath}/${fileName}"

                var file = File(picPath)

                //저장된 경로에 Uri 가져오기
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    contentUri = FileProvider.getUriForFile(this, "com.example.maerad7.doseokhttpmultipart.file_provider", file)
                } else {
                    contentUri = Uri.fromFile(file)
                }

                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri)
                startActivityForResult(camera_intent, 1)


            }
            R.id.menu_gallery ->{
                var gallery_intent = Intent(Intent.ACTION_PICK)
                gallery_intent.type = MediaStore.Images.Media.CONTENT_TYPE
                startActivityForResult(gallery_intent,2)

            }
            R.id.menu_upload -> {
                var thread = UploadThread()
                thread.start()
            }
        }

        return super.onOptionsItemSelected(item)

    }

    //이미지 저장
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode ==1){
            if(resultCode== Activity.RESULT_OK){
                var bitmap = BitmapFactory.decodeFile(contentUri?.path)

                bitmap = resizeBitmap(1024,bitmap)
                var degree = getDegree(contentUri?.path)
                pic_path = contentUri?.path
                rebuildImage(bitmap,pic_path!!,degree)

                imageView2.setImageBitmap(bitmap)
                imageView2.rotation =degree
            }
        }else if(requestCode == 2 ){
            if(resultCode == RESULT_OK){
                var c = contentResolver.query(data?.data,null,null,null,null)
                c.moveToNext()

                var index = c.getColumnIndex(MediaStore.Images.Media.DATA)
                var source = c.getString(index)



                var bitmap =BitmapFactory.decodeFile(source)

                bitmap = resizeBitmap(1024,bitmap)
                var degree = getDegree(source)

                var fileName = "temp_${System.currentTimeMillis()}.jpg"
                pic_path ="${dirPath}/${fileName}"
                rebuildImage(bitmap,pic_path!!,degree)

                imageView2.setImageBitmap(bitmap)
                imageView2.rotation = degree
            }
        }
    }

    //이미지의 사이즈를 줄이는 메소드
     fun resizeBitmap(targetWidth : Int, source : Bitmap) : Bitmap{
        // 이미지의 비율 구하기
        var ratio = source.height.toDouble() / source.width.toDouble()
        var targetHeight = (targetWidth* ratio).toInt()

        var result = Bitmap.createScaledBitmap(source,targetWidth,targetHeight,false)
        if(result != source){
            source.recycle()
        }
        return result
    }

    //각도값 구하기
    fun getDegree(path : String ?): Float{
        var exif = ExifInterface(path)

        var degree = 0

        //회전 각도 값 구하기
        var ori = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION,-1)
        when(ori){
            ExifInterface.ORIENTATION_ROTATE_90->{
                degree = 90
            }
            ExifInterface.ORIENTATION_ROTATE_180->{
                degree = 180
            }
            ExifInterface.ORIENTATION_ROTATE_270->{
                degree = 270
            }

        }
        return degree.toFloat()
    }

    //
    fun rebuildImage(source : Bitmap, path : String, angle:Float){
        var matrix = Matrix()
        matrix.postRotate(angle)

        //matrix -> 회전 각도 값 ,, 이미지 전체를 각도값을 적용하여 생성
        var bitmap2 = Bitmap.createBitmap(source,0,0,source.width, source.height,matrix,false)

        //경로에 이미지 파일 저장
        var out = FileOutputStream(path)
        bitmap2.compress(Bitmap.CompressFormat.JPEG,100,out)
        out.flush()
        out.close()
    }

    //업로드
    inner class UploadThread : Thread(){
        override fun run() {
            var client = OkHttpClient()

            var request_builder = Request.Builder()
            var url = request_builder.url("http://192.168.0.3:8080/MobileServer/upload.jsp")

            //파일을 보내기 위해 멀티파트
            var multipart_builder = MultipartBody.Builder()
            multipart_builder.setType(MultipartBody.FORM)

            multipart_builder.addFormDataPart("mobile_str1",editText.text.toString())
            multipart_builder.addFormDataPart("mobile_str2",editText2.text.toString())


            var file = File(pic_path)
            multipart_builder.addFormDataPart("mobile_img",file.name, RequestBody.create(MultipartBody.FORM,file))
            var body = multipart_builder.build()

            var post = url.post(body)

            var reuqest = post.build()

            var callBack1 = CallBack1()

            client.newCall(reuqest).enqueue(callBack1)
        }
    }
    inner class CallBack1 : Callback{
        override fun onFailure(call: Call?, e: IOException?) {
        }

        override fun onResponse(call: Call?, response: Response?) {
            var result = response?.body()?.string()

            if(result?.trim().equals("OK")){
                finish()
            }
        }

    }
}