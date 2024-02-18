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

        binding.btnSubmit.setOnClickListener {
            getData()
        }


    }

     //TejPrakash18

        private fun getData(){
            val word = binding.etWord.editableText.toString()
            RetrofitIntance.apiInterface?.getInfo(word)?.enqueue(object :Callback<List<MyDataClass>> {
                override fun onResponse(call: Call<List<MyDataClass>>, response: Response<List<MyDataClass>>) {
                    if (response.isSuccessful) {

                        val result= response.body()

                        for(item in result!!) {
                            binding.tvWord.text = item.word
                            binding.tVMeaning.text = item.meanings.toString()
                        }

                    }
                }

                override fun onFailure(call: Call<List<MyDataClass>>, t: Throwable) {
                    Toast.makeText(this@SecondAcitivity,t.localizedMessage,Toast.LENGTH_LONG).show()
                }
            })
        }
}


