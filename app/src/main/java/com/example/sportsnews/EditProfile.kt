package com.example.sportsnews

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class EditProfile : AppCompatActivity() {
    lateinit var toolbarx : Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)


        toolbarx = findViewById(R.id.Toolbarx)

        toolbarx.title = "Edit Profile"

        window.setStatusBarColor(Color.parseColor("#03A9F4"))





        setuptoolbar()



    }

    private fun setuptoolbar() {

        setSupportActionBar(toolbarx)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val upArrow = ContextCompat.getDrawable(this, R.drawable.btn_back)
        upArrow?.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
        supportActionBar?.setHomeAsUpIndicator(upArrow)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}