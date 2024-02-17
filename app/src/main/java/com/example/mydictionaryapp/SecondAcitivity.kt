package com.example.mydictionaryapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SecondAcitivity : AppCompatActivity() {

    lateinit var retrofitData: Call<List<MyDataClass>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val etWord= findViewById<EditText>(R.id.etWord)
        val btnSubmit= findViewById<Button>(R.id.btnSubmit)
        val tvWord= findViewById<TextView>(R.id.tvWord)
        val tvMeaning= findViewById<TextView>(R.id.tVMeaning)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/entries/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIINterface::class.java)

        btnSubmit.setOnClickListener {
            val word= etWord.text.toString()

            retrofitData= retrofit.getInfo(word)

            retrofitData.enqueue(object : Callback<List<MyDataClass>>{
                override fun onResponse(call: Call<List<MyDataClass>>,  response: Response<List<MyDataClass>>
                ) {
                    val result= response.body()

                    for(item in result!!){
                        tvWord.text= item.word
                        tvMeaning.text= item.meanings.toString()
                    }
                }

                override fun onFailure(call: Call<List<MyDataClass>>, t: Throwable) {
                    Toast.makeText(this@SecondAcitivity, "Something wrong", Toast.LENGTH_SHORT).show()
                }

            })
        }


    }
}