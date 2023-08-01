package com.example.sportsnews.api


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory





object RatrofitHelper {

      private const val BASE_URL = "https://e4e6-2401-4900-1c88-4fc8-dc94-1bd4-119a-f04b.ngrok-free.app/api/v1/"



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

      fun getMyApi() : apiInterface {
          return getInstance().create(apiInterface::class.java)

      }





  }