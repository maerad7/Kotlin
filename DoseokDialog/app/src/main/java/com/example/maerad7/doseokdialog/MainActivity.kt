package com.example.maerad7.doseokdialog

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var pro:ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            view ->
            var builder = AlertDialog.Builder(this)
            builder.setTitle("기본 다이어로그")
            builder.setMessage("다이어로그의 본문입니다.")
            builder.setIcon(R.mipmap.ic_launcher)

            //익멱 클래스니까 object 붙임
            var listner = object:DialogInterface.OnClickListener{

                //p1 이 어떤 버튼을 눌렀는지 구변하는 값
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when(p1){
                        DialogInterface.BUTTON_POSITIVE->textView.text="Positive"
                        DialogInterface.BUTTON_NEUTRAL->textView.text="Neutral"
                        DialogInterface.BUTTON_NEGATIVE->textView.text="Negative"
                    }
                }

            }
            builder.setPositiveButton("확인",listner)
            builder.setNeutralButton("중간",listner)
            builder.setNegativeButton("취소",listner)
            //var alert = builder.create()
            //alert.show()
            builder.show()
        }

        //cutstom DIalog
        button2.setOnClickListener { view ->
            var builder = AlertDialog.Builder(this)
                    builder.setTitle("커스텀 다이어로그")
                    builder.setIcon(R.mipmap.ic_launcher)

            var v1 = layoutInflater.inflate(R.layout.dialog,null)
            builder.setView(v1)

            var listner = object:DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    var alert = p0 as AlertDialog
                    var edit1:EditText? = alert.findViewById<EditText>(R.id.editText)
                    var edit2:EditText? = alert.findViewById<EditText>(R.id.editText2)

                    textView.text="edit1 : ${edit1?.text}\n"
                    textView.append("edit2 : ${edit2?.text}")
                    }
                }

            builder.setPositiveButton("확인",listner)
            builder.setNegativeButton("취소",null)

            builder.show()
            }

        //DatePicker
        button3.setOnClickListener { view ->
            var calendar = Calendar.getInstance()
            var year = calendar.get(Calendar.YEAR)
            var month = calendar.get(Calendar.MONTH)
            var day = calendar.get(Calendar.DAY_OF_MONTH)

            var listner = object : DatePickerDialog.OnDateSetListener {

                //p1 년, p2 월, p3 일
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    textView.text = " ${p1}년 ${p2}월 ${p3}일"
                }
            }
                var picker = DatePickerDialog(this,listner,year,month,day)
                picker.show()
        }

        //timepicker
        button4.setOnClickListener {view ->
            var calendar = Calendar.getInstance()
            var hour = calendar.get(Calendar.HOUR)
            var minute = calendar.get(Calendar.MINUTE)

            var listener = object : TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    textView.text = "${p1}시 ${p2}분"
                }

            }

            //true 24시간제 , false 12시간제
            var picker = TimePickerDialog(this,listener,hour,minute,false)
            picker.show()


        }

        //프로그레스 다이어로그
        button5.setOnClickListener{view ->
            pro = ProgressDialog.show(this,"타이틀입니다.","메시지입니다.")

            var handler = Handler()
            var thread = object:Runnable{
                override fun run() {
                    pro?.cancel()
                }

            }
            //5초후에 쓰레드에 있는 런메소드를 호출해라.
            handler.postDelayed(thread,5000)
        }

    }



}


