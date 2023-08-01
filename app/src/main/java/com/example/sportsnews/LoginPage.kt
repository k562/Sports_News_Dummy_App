package com.example.sportsnews

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlin.math.sign

class LoginPage : AppCompatActivity() {

    lateinit var btnlogin : Button
    lateinit var signuptxt : TextView
    lateinit var EditEmailadress : EditText
    lateinit var EditPassword : EditText
    lateinit var firebaseDatabase: FirebaseDatabase

    lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        window.setStatusBarColor(Color.parseColor("#03A9F4"))

        btnlogin = findViewById(R.id.btnlogin)
        signuptxt = findViewById(R.id.signuptxt)
        EditEmailadress = findViewById(R.id.editEmailaddress)
        EditPassword = findViewById(R.id.editPassword)


        firebaseAuth = FirebaseAuth.getInstance()

        firebaseDatabase = FirebaseDatabase.getInstance()


        btnlogin.setOnClickListener {

           login()

        }

        signuptxt.setOnClickListener {

            val intent = Intent(this@LoginPage , SignUpPage::class.java)
            startActivity(intent)

        }




    }

    private fun login(){

        val email : String = EditEmailadress.text.toString()
        val password : String = EditPassword.text.toString()


        if(email.isEmpty() || password.isEmpty()) {

            if (email.isEmpty()) {

                EditEmailadress.error = "Enter your email id"
            }

            if (password.isEmpty()) {

                EditPassword.error = "Enter yuour password"

            }

            Toast.makeText(this, "Email or Password cannot be empty", Toast.LENGTH_LONG).show()

        } else {

                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){

                    if (it.isSuccessful){

                        Toast.makeText(this,"Login Successfull",Toast.LENGTH_LONG).show()

                        val intent = Intent(this@LoginPage , MainActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {

                        Toast.makeText(this,"Login Failed",Toast.LENGTH_LONG).show()

                    }

                }


        }


        if (email.isBlank() || password.isBlank()){

            Toast.makeText(this,"Email or Password cannot be empty",Toast.LENGTH_LONG).show()
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){

         if (it.isSuccessful){

             Toast.makeText(this,"Login Successfull",Toast.LENGTH_LONG).show()

             val intent = Intent(this@LoginPage , MainActivity::class.java)
             startActivity(intent)
             finish()

         } else {

             Toast.makeText(this,"Login Failed",Toast.LENGTH_LONG).show()

         }

        }

    }
}