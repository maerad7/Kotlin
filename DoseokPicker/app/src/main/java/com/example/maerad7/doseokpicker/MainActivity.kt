package com.example.maerad7.doseokpicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    //현재시간 받아오기
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonDatePicker.setOnClickListener {
            showDatePicker()
        }
        buttonTimePicker.setOnClickListener {
            showTimePicker()
        }
    }
    fun showDatePicker(){
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
            println(year)
            println(month + 1 )
            println(day)
        },cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DATE)).show()
    }
    fun showTimePicker(){
        TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            println(hour)
            println(minute)
        },cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),true).show()
    }
}
