package com.example.sportsnews

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.sign

class LoginPage : AppCompatActivity() {

    lateinit var btnlogin : Button
    lateinit var signuptxt : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        window.setStatusBarColor(Color.parseColor("#03A9F4"))

        btnlogin = findViewById(R.id.btnlogin)
        signuptxt = findViewById(R.id.signuptxt)


        btnlogin.setOnClickListener {

            val intent = Intent(this@LoginPage , MainActivity::class.java)
            startActivity(intent)

        }

        signuptxt.setOnClickListener {

            val intent = Intent(this@LoginPage , SignUpPage::class.java)
            startActivity(intent)
        }


    }
}