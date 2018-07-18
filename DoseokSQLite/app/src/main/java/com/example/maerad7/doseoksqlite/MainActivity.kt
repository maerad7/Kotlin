package com.example.maerad7.doseoksqlite

import android.content.ContentValues
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //INSERT
        button.setOnClickListener { view ->
            var helper = DBHelper(this)

            var db = helper.writableDatabase
//
//            var sql = "Insert into TestTable(textData,intData,floatData,dateData) values (?,?,?,?)"
//
//            var sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
//            var date = sdf.format(Date())
//
//            var arg1 = arrayOf("문자열1","100","11.11",date)
//            var arg2 = arrayOf("문자열2","200","22.22",date)
//
//            db.execSQL(sql,arg1)
//            db.execSQL(sql,arg2)
            var sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            var date = sdf.format(Date())

            var cv1 = ContentValues()
            cv1.put("textData","문자열1")
            cv1.put("intData",100)
            cv1.put("FloatData",11.11)
            cv1.put("dateData",date)

            db.insert("TestTable",null,cv1)

            var cv2 = ContentValues()
            cv2.put("textData","문자열2")
            cv2.put("intData",200)
            cv2.put("FloatData",22.22)
            cv2.put("dateData",date)

            db.insert("TestTable",null,cv2)
            db.close()

            textView.text= "저장완료"
        }

        //SELECT


        button2.setOnClickListener { view ->
            var helper:DBHelper = DBHelper(this)
            var db = helper.writableDatabase

//            var sql = "select * from TestTable"
//          ========================================================================
//            String query="SELECT id, name FROM people WHERE name = ? AND roll = ?";
//            String[] selectionArgs = {"Amit","7"}
//            db.rawQuery(query, selectionArgs);
//          ========================================================================

//            var c : Cursor = db.rawQuery(sql,null)
            // 첫번째는 : 테이블의 이름
            // 두번째 : 가져올 컬럼 이름의 문자열 배열
            // 세번째는 조건절 : "a=? and b=?"
            // 네번째는 물음표에 세팅될 배열형태의 값
            // 다섯번째는 : 정렬
            // 6번째는 : group by
            // 일곱번째 : having
            var c = db.query("TestTable",null,null,null,null,null,null)
            textView.text = ""

            while (c.moveToNext()){
                var idx_pos = c.getColumnIndex("idx")
                var textData_pos = c.getColumnIndex("textData")
                var intData_pos = c.getColumnIndex("intData")
                var floatData_pos = c.getColumnIndex("floatData")
                var dateData_pos = c.getColumnIndex("dateData")

                var idx = c.getInt(idx_pos)
                var textData = c.getString(textData_pos)
                var intData = c.getInt(intData_pos)
                var floatData = c.getFloat(floatData_pos)
                var dateData = c.getString(dateData_pos)

                textView.append("idx : ${idx}\n")
                textView.append("textData : ${textData}\n")
                textView.append("intData : ${intData}\n")
                textView.append("floatData : ${floatData}\n")
                textView.append("dateData : ${dateData}\n")

            }

            db.close()
        }

        //UPDATE
        button3.setOnClickListener { view ->
            var helper = DBHelper(this)
            var db = helper.writableDatabase

//            var sql = "update TestTable set textData=? where idx=?"
//            var args = arrayOf("문자열3","1")
//
//
//            db.execSQL(sql,args)
            var cv = ContentValues()
            cv.put("textData","3")
            var where = "idx=?"
            var args = arrayOf("1")
            //테이블,contentvalue,조건절, 조건절 변수 내용
            db.update("TestTable",cv,where,args)
            db.close()

            textView.text="수정완료"
        }

        //DELETE
        button4.setOnClickListener { view ->
            var helper = DBHelper(this)
            var db = helper.writableDatabase

//            var sql = "delete from TestTable where idx =?"
//            var args = arrayOf("1")
//
//            db.execSQL(sql,args)

            var where = "idx=?"
            var args = arrayOf("1")

            db.delete("TestTable",where,args)
            db.close()
            textView.text = "삭제완료"

        }
    }
}
