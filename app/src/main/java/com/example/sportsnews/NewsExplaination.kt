package com.example.sportsnews

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.sportsnews.viewmodels.NewsMainViewModel

class NewsExplaination : AppCompatActivity() {

    lateinit var toolbaractivity : Toolbar
    lateinit var imageView : ImageView
    lateinit var views : TextView
    lateinit var timing : TextView
    lateinit var date  : TextView
    lateinit var titlenews : TextView
    lateinit var newsdes : TextView



    lateinit var newsExplainationviewModel : NewsMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_explaination)


        toolbaractivity = findViewById(R.id.toolbaractivity)

        imageView = findViewById(R.id.imageView)
        views = findViewById(R.id.views)
        timing = findViewById(R.id.timing)
        date = findViewById(R.id.date)
        titlenews = findViewById(R.id.titlenews)
        newsdes = findViewById(R.id.newsdes)



        updateUI()


        newsExplainationviewModel = ViewModelProvider(this
        )[NewsMainViewModel::class.java]

        // Retrieve data from the intent extras
        val newsId = intent.getStringExtra("newsId")

        newsExplainationviewModel.newsDetails(
                userId = "2",
                securityToken = "22",
                versionName = "12",
                versionCode = "11",
                newsId = ""
            ).observe(this, Observer {
                if (it != null) {
                    // Display data for highlights news
                    views.text = it.newsDetails.highlights[0].newsViews
                    timing.text = it.newsDetails.highlights[0].newsTime
                    date.text = it.newsDetails.highlights[0].newsDate
                    titlenews.text = it.newsDetails.highlights[0].newsTitle
                    newsdes.text = it.newsDetails.highlights[0].newsDescription

                    Glide.with(this)
                        .load(it.newsDetails.highlights[0].newsImage)
                        .placeholder(R.drawable.error)
                        .into(imageView)
                }
            })

            // Observe and display data for trending news
            newsExplainationviewModel.newsDetails(
                userId = "2",
                securityToken = "22",
                versionName = "12",
                versionCode = "11",
                newsId = "",
            ).observe(this, Observer {
                if (it != null) {
                    // Display data for trending news
                    views.text = it.newsDetails.trendingNews[0].newsViews
                    timing.text = it.newsDetails.trendingNews[0].newsTime
                    date.text = it.newsDetails.trendingNews[0].newsDate
                    titlenews.text = it.newsDetails.trendingNews[0].newsTitle
                    newsdes.text = it.newsDetails.trendingNews[0].newsDescription

                    Glide.with(this)
                        .load(it.newsDetails.trendingNews[0].newsImage)
                        .placeholder(R.drawable.error)
                        .into(imageView)
                }
            })

        newsExplainationviewModel.newsDetails(
            userId = "2",
            securityToken = "22",
            versionName = "12",
            versionCode = "11",
            newsId = "",
        ).observe(this, Observer {
            if (it != null) {
                // Display data for trending news
                views.text = it.newsDetails.trendingNews[0].newsViews
                timing.text = it.newsDetails.trendingNews[0].newsTime
                date.text = it.newsDetails.trendingNews[0].newsDate
                titlenews.text = it.newsDetails.trendingNews[0].newsTitle
                newsdes.text = it.newsDetails.trendingNews[0].newsDescription

                Glide.with(this)
                    .load(it.newsDetails.trendingNews[0].newsImage)
                    .placeholder(R.drawable.error)
                    .into(imageView)
            }
        })    // Observe and display data for trending news
        newsExplainationviewModel.newsDetails(
            userId = "2",
            securityToken = "22",
            versionName = "12",
            versionCode = "11",
            newsId = "",
        ).observe(this, Observer {
            if (it != null) {
                // Display data for trending news
                views.text = it.newsDetails.trendingNews[0].newsViews
                timing.text = it.newsDetails.trendingNews[0].newsTime
                date.text = it.newsDetails.trendingNews[0].newsDate
                titlenews.text = it.newsDetails.trendingNews[0].newsTitle
                newsdes.text = it.newsDetails.trendingNews[0].newsDescription

                Glide.with(this)
                    .load(it.newsDetails.trendingNews[0].newsImage)
                    .placeholder(R.drawable.error)
                    .into(imageView)
            }
        })


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun updateUI(){

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

    }
}