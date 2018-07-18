package com.example.maerad7.doseokretrofit

import retrofit2.Call
import retrofit2.http.*

data class ResponseDTO(var result:String? = null)
interface DoseokService{

    @GET("/howl")
    fun getRequest(@Query("name")name:String): Call<ResponseDTO>

    @GET("/howl/{id}")
    fun getParamReuquest(@Path("id")id:String):Call<ResponseDTO>

    //form data, urlencoded 방식 두개가 있다   @FormUrlEncoded -> @field가 있으면 인코드 써주기
    @FormUrlEncoded
    @POST("/howl")
    fun postRequest(@Field("id")id:String,
                    @Field("password")password:String):Call<ResponseDTO>
    @FormUrlEncoded
    @PUT("/howl/{id}")
    fun putrequest(@Field("id")id : String,
                   @Field("content") content:String) : Call<ResponseDTO>

    @DELETE("/howl/{id}")
    fun deleteRequest(@Path("id")id:String):  Call<ResponseDTO>

}