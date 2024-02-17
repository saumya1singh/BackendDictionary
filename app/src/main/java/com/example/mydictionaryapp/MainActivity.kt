package com.example.mydictionaryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
           val i= Intent(this, SecondAcitivity::class.java)
            startActivity(i)
            finish()
        },3000)
    }
}