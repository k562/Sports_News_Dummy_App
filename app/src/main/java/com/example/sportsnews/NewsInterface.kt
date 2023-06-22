package com.example.sportsnews

import android.telecom.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

  //  https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=04a4b3ccea7a4e638f5f5d5c17b0e161

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "04a4b3ccea7a4e638f5f5d5c17b0e161"

interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getheadlines(@Query("country")country : String , @Query("page")page : Int , @Query("category") category : String) : retrofit2.Call<Newsdata>


  }

   object Newsservice {

     val newsInstance : NewsInterface

    init {

   val ratrofit = Retrofit.Builder()
       .baseUrl(BASE_URL)
       .addConverterFactory(GsonConverterFactory.create())
       .build()
        newsInstance  = ratrofit.create(NewsInterface::class.java)


    }

   }