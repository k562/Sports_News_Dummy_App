package com.example.sportsnews.api



import com.example.sportsnews.models.Newsdata
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


    //  https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=04a4b3ccea7a4e638f5f5d5c17b0e161


const val API_KEY = "04a4b3ccea7a4e638f5f5d5c17b0e161"


 interface apiInterface {

     // New list
     @GET("v2/top-headlines?apiKey=${API_KEY}")
     suspend fun getheadlines(
         @Query("country") country: String,
         @Query("page") page: Int,
         @Query("category") category: String
     ): Newsdata


     // Match board

//     @POST("sportsNews")
//     suspend fun matchstatus(): Matches

 }






