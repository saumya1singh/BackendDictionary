package com.example.mydictionaryapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mydictionaryapp.databinding.ActivitySecondBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SecondAcitivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    lateinit var retrofitData: Call<List<MyDataClass>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        val etWord= findViewById<EditText>(R.id.etWord)
//        val btnSubmit= findViewById<Button>(R.id.btnSubmit)
//        val tvWord= findViewById<TextView>(R.id.tvWord)
//        val tvMeaning= findViewById<TextView>(R.id.tVMeaning)

        //TejPrakash18

        val BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/"

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIInterface::class.java)

        binding.btnSubmit.setOnClickListener {
            val word= binding.etWord.text.toString()

            retrofitData= retrofit.getInfo(word)

            retrofitData.enqueue(object : Callback<List<MyDataClass>>{
                override fun onResponse(call: Call<List<MyDataClass>>,  response: Response<List<MyDataClass>>
                ) {
                    val result= response.body()

                    for(item in result!!){
                        binding.tvWord.text= item.word
                        binding.tVMeaning.text= item.meanings.toString()
                    }
                }

                override fun onFailure(call: Call<List<MyDataClass>>, t: Throwable) {
                    Toast.makeText(this@SecondAcitivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

            })
        }


    }
}