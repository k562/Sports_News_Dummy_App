package com.example.sportsnews

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

//https://a226-2401-4900-1c74-84f9-65c7-9869-8201-1e68.ngrok-free.app/api/v1/Matchlist


  const val BASEURL2 = "https://1231-2401-4900-1c74-46ad-4dfb-3e72-11e1-bd1c.ngrok-free.app/"

interface LiveInterface {


  @GET("api/v1/Matchlist")
  fun getlivelist():Call<ListMatch>


  }

 object liveservice {

   private val loggingInterceptor = HttpLoggingInterceptor().apply {
     level = HttpLoggingInterceptor.Level.BODY
   }


   val liveinstance : LiveInterface

   init{

     val client = OkHttpClient.Builder()
       .addInterceptor(loggingInterceptor)
       .build()

     val ratrofit  = Retrofit.Builder()
       .baseUrl(BASEURL2)
       .addConverterFactory(GsonConverterFactory.create())
       .client(client)
       .build()
       liveinstance = ratrofit.create(LiveInterface::class.java)

   }
 }