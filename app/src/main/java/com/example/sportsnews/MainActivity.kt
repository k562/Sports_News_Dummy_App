package com.example.sportsnews

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.sportsnews.Fragments.NewsFragment
import com.example.sportsnews.Fragments.RankingFragment
import com.example.sportsnews.Fragments.SeriesFragment
import com.example.sportsnews.Fragments.UpcomingFragment
import com.example.sportsnews.Fragments.live_Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import meow.bottomnavigation.MeowBottomNavigation

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var bottomnavigationview : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setStatusBarColor(Color.parseColor("#03A9F4"))
        toolbar = findViewById(R.id.Toolbar)
        bottomnavigationview = findViewById(R.id.BottomNavigationView)



        // Retrieve the current state of dark mode from preferences or app settings
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val isDarkModeEnabled = preferences.getBoolean("dark_mode_enabled", false)

        // Apply the appropriate theme based on the current state of dark mode
        if (isDarkModeEnabled) {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        } else {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        }

        replacewithFragment(live_Fragment())

        setuptoolbar()



        bottomnavigationview.setOnItemSelectedListener {

            when(it.itemId){
                R.id.live -> replacewithFragment(live_Fragment())
                R.id.news -> replacewithFragment(NewsFragment())
                R.id.profile -> replacewithFragment(RankingFragment())
//              R.id.series -> replacewithFragment(SeriesFragment())
                R.id.upcoming -> replacewithFragment(UpcomingFragment())

                else -> {

                }
            }

           true
        }



    }

     fun replacewithFragment(fragment : Fragment){

         val fragmentmanager = supportFragmentManager
         val transaction = fragmentmanager.beginTransaction()
         transaction.replace(R.id.Framelayout , fragment)
         transaction.commit()
     }



    private fun setuptoolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Sports News"
//        supportActionBar?.setHomeButtonEnabled(true)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_drawer,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when(item.itemId){


            R.id.darkmode -> {

                val preferences = PreferenceManager.getDefaultSharedPreferences(this)
                val isDarkModeEnabled = preferences.getBoolean("dark_mode_enabled", false)

                // Toggle the state of dark mode
                val newDarkModeState = !isDarkModeEnabled
                preferences.edit().putBoolean("dark_mode_enabled", newDarkModeState).apply()

                if (newDarkModeState) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }

                recreate()
                return true


            }
        }

        return super.onOptionsItemSelected(item)
    }


}