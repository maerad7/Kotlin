package com.example.maerad7.doseokretrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.3:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        var server = retrofit.create(DoseokService::class.java)


        //GET 방식
        button_get.setOnClickListener {
            server.getRequest("하울").enqueue(object:Callback<ResponseDTO>{
                override fun onFailure(call: Call<ResponseDTO>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<ResponseDTO>?, response: Response<ResponseDTO>?) {
                    println(response?.body().toString())
                }

            })
        }

        //get_param 방식
        button_getParam.setOnClickListener {
            server.getParamReuquest("board01").enqueue(object:Callback<ResponseDTO>{
                override fun onFailure(call: Call<ResponseDTO>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<ResponseDTO>?, response: Response<ResponseDTO>?) {
                    println(response?.body().toString())
                }

            })
        }

        //post방식
        button_post.setOnClickListener {
            server.postRequest("maerad7@naver.com","1234").enqueue(object:Callback<ResponseDTO>{
                override fun onFailure(call: Call<ResponseDTO>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<ResponseDTO>?, response: Response<ResponseDTO>?) {
                    println(response?.body().toString())
                }

            })
        }

        //update
        button_update.setOnClickListener {
            server.putrequest("board01","수정할 내용").enqueue(object:Callback<ResponseDTO>{
                override fun onFailure(call: Call<ResponseDTO>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<ResponseDTO>?, response: Response<ResponseDTO>?) {
                    println(response?.body().toString())
                }

            })
        }

        //delete
        button_delete.setOnClickListener{
            server.deleteRequest("board01").enqueue(object:Callback<ResponseDTO>{
                override fun onFailure(call: Call<ResponseDTO>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<ResponseDTO>?, response: Response<ResponseDTO>?) {
                    println(response?.body().toString())
                }

            })
        }


    }
}
