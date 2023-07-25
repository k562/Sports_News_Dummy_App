package com.example.sportsnews

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SignUpPage : AppCompatActivity() {

    lateinit var textsignin : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        window.setStatusBarColor(Color.parseColor("#03A9F4"))

        textsignin = findViewById(R.id.txtsignin)

        textsignin.setOnClickListener {

            val intent = Intent(this@SignUpPage, LoginPage :: class.java)
            startActivity(intent)
        }

    }
}