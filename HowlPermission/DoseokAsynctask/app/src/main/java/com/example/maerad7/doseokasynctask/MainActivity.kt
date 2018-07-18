package com.example.maerad7.doseokasynctask

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //입력 값 , 처리된 값, 최종값
        var async = object : AsyncTask<Int, Int, String>(){

            // 백그라운드로 값이 연산 되는 부분
            override fun doInBackground(vararg p0: Int?): String {
                var position = p0[0]!!
                while(position<100){
                    Thread.sleep(3000)
                    position = position + 1

                    //onProgressUpdate에 값을 넘기는 함수
                    publishProgress(position)
                }
                return "다운로드가 끝났습니다."
                //return값이 onPostExcute로 넘어감
            }

            // 중간 값이 출력되는 부분
            override fun onProgressUpdate(vararg values: Int?) {
                super.onProgressUpdate(*values)
                textView_main.setText(values[0].toString()+"%")
            }

            //최종 값이 출력되는 부분
            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                textView_main.setText(result)
            }

        }
        //doinBackground의 p0로 값이 넘어감
        async.execute(20)
    }
}
