package com.example.sportsnews

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class NewsExplaination : AppCompatActivity() {

    lateinit var toolbaractivity : Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_explaination)


        toolbaractivity = findViewById(R.id.toolbaractivity)

        setSupportActionBar(toolbaractivity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val upArrow = ContextCompat.getDrawable(this, R.drawable.btn_back)
        upArrow?.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
        supportActionBar?.setHomeAsUpIndicator(upArrow)
       // supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back_white)

        val window = window

        window.statusBarColor = Color.parseColor("#03A9F4")

        title = "News"

//        val title = intent.getStringExtra("title")
//        supportActionBar?.title = title


        }

        override fun onSupportNavigateUp(): Boolean {
            onBackPressed()
            return true
        }
    }