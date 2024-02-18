package com.example.mydictionaryapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIInterface {
    @GET("en/{word}")
    fun getInfo(@Path("word") word: String) : Call<List<MyDataClass>>


}