package com.example.maerad7.doseokasynctask2

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { view ->
            var time = System.currentTimeMillis()
            textView.text = "버튼클릭: ${time}"

        }
        var sync = AsyncTaskClass()
        sync.execute(10,20)
    }

    //첫번째 제너릭은 execute메소드의 파라미터,doinbackground의 매개 변수이기도 하다.
    //두번째 제너릭은 publishProgress의 파라미터이다. onProgressUpdate의 파라미터로 배열로 넘어간다.
    //세번째 파라미터는 doInBackground의 리턴 타입이다. onPostExecute의 파라미터로 들어온다.
    inner class AsyncTaskClass : AsyncTask<Int,Long,String>() {
        //doinBackground가 호출되기전에 호출, 메인 스레드에서 동작함
        override fun onPreExecute() {
            super.onPreExecute()
            textView2.text = "AsyncTask 가동"
        }
        //일반 쓰레드에서 처리(오레오 이하에선 일반쓰레드에서 화면컨트롤 못함)
        override fun doInBackground(vararg p0: Int?): String {
            var a1 =p0[0]!!
            var a2 =p0[1]!!

            for(i in 0..9){
                SystemClock.sleep(1000 )
                a1++
                a2++
                Log.d("test1","${i} : ${a1},${a2}")
                //textView2.text = "${i} : ${a1},${a2}"
                var time = System.currentTimeMillis()
                publishProgress(time)
            }
            return "수행이 완료되었습니다"
        }
    //publishProgress 파라미터 -> values로 들어옴, 메인스레드에서 처리
        override fun onProgressUpdate(vararg values: Long?) {
            super.onProgressUpdate(*values)
            textView2.text = "Async:${values[0]}"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            textView2.text = result

        }
    }
}
