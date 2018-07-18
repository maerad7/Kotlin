package com.example.maerad7.doseokonactivityresult

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val SECONDACTIVITY = 1
    val THIRDACTIVITY = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button2.setOnClickListener { view ->
            var intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, SECONDACTIVITY)
        }
        button4.setOnClickListener {
            var intent = Intent(this, ThirdActivity::class.java)
            startActivityForResult(intent, THIRDACTIVITY)
        }
    }

    //세컨드 액티비티에서 finsh로 돌아올때 호출
    //requestCode -> startActivityForResult의 두번째 파라미터랑 같다
    //resultCode->세컨드 액티비티에서 setResult의 정수값을 받아온다.
    //requestcode 어떤액티비티를 갔다 왔나
    //resultcode 새로운 실행된 액티비티에서 결과가 어떤 것이냐
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SECONDACTIVITY) {
            textView2.text = "Second Activity에서 돌아옴\n"
            when(resultCode){
                Activity.RESULT_OK -> textView2.append("RESULT_OK")
                Activity.RESULT_CANCELED -> textView2.append("RESULT_CANCLED")
                Activity.RESULT_FIRST_USER -> textView2.append("RESULT_FIRST_USER")
            }
        }else if (requestCode==THIRDACTIVITY) {
            textView2.text = "Third Activity에서 돌아옴"
        }
    }
}
