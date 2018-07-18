package com.example.maerad7.doseoksqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper(context : Context) : SQLiteOpenHelper(context, "Test.db",null,1) {
    //Test.db가 있나 확인해보고 없으면 DB를 만든다.
    override fun onCreate(p0: SQLiteDatabase?) {
        Log.d("msg","on create")

        var sql = "Create table TestTable (" +
                "idx integer primary key autoincrement," +
                "textData text not null," +
                "intData integer not null, "+
                "floatData real not null," +
                "dateData date not null" +
                  ")"
        //쿼리 실행
        p0?.execSQL(sql)
    }
    //p1 이전 버전 값, p2 새로운 버전 값
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        Log.d("msg","oldVersion : ${p1}, newVersion : ${p2}")
    }
}