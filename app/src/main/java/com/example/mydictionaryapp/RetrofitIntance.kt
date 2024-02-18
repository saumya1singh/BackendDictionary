package com.example.mydictionaryapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitIntance {
    private const val BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/"

    private val RetrofitInstance by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiInterface by lazy {
        RetrofitInstance?.create(APIInterface::class.java)
    }
}