package com.example.sportsnews.api


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//  https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=04a4b3ccea7a4e638f5f5d5c17b0e161



  object RatrofitHelper {

      private const val BASE_URL = "https://newsapi.org/"

//      private const val BASE_URL = "https://55d0-2401-4900-1c88-4eb8-2c5f-fd0f-fa0f-9c9d.ngrok-free.app/api/v1"



       fun getInstance () : Retrofit {

           val loggingInterceptor = HttpLoggingInterceptor()
           loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
           val okHttpClient = OkHttpClient.Builder()
               .addInterceptor(loggingInterceptor)
               .build()

           return Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .client(okHttpClient)
               .build()

       }





  }