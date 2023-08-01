package com.example.sportsnews.api



import com.example.sportsnews.models.Matchlist
import com.example.sportsnews.models.NewInfo
import com.example.sportsnews.models.NewsDetails_2
import com.example.sportsnews.models.NewsTrendingHighlights
import com.example.sportsnews.models.UpcomingList
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface apiInterface {

     // Newinfo list
     @FormUrlEncoded
     @POST("newsList")
      fun getnewsInfo(
        @Field("userId")userId : String ,
        @Field("securityToken")securityToken: String ,
        @Field("versionName")versionName: String ,
        @Field("versionCode")versionCode: String,
        @Field("newsId")newsId: String,
        @Field("newsCategory")newsCategory: String ): Call<NewInfo>


     // Match list
     @FormUrlEncoded
     @POST("sportsNews")
      fun getMatchList(
         @Field("userId") userId :String,
         @Field("securityToken")securityToken : String ,
         @Field("versionName")versionName : String,
         @Field("versionCode") versionCode: String): Call<Matchlist>

    // Latest News list
     @FormUrlEncoded
     @POST("sportsNews")
     fun getNewslist (
          @Field("userId") userId: String ,
          @Field("securityToken")securityToken: String ,
          @Field("versionName")versionName: String ,
          @Field("versionCode")versionCode: String ) : Call<Matchlist>


     @FormUrlEncoded
     @POST("upcomingMatches")
     fun getupcominglist(
         @Field("userId") userId: String,
         @Field("securityToken")securityToken: String,
         @Field("versionName")versionName: String,
         @Field("versionCode")versionCode: String ) : Call<UpcomingList>



     @FormUrlEncoded
     @POST("newsDetails")
     fun getNewsTrendingHighlights(
         @Field("userId") userId: String,
         @Field("securityToken")securityToken: String,
         @Field("versionName")versionName: String,
         @Field("versionCode")versionCode: String,

         @Field("newsCategory")newsCategory: String ,
         ) : Call <NewsTrendingHighlights>




        @FormUrlEncoded
        @POST("newsDetails")
        fun getNewsHighlights(
            @Field("userId") userId: String,
            @Field("securityToken")securityToken: String,
            @Field("versionName")versionName: String,
            @Field("versionCode")versionCode: String,
            @Field("newsCategory")newsCategory: String , ) : Call <NewsTrendingHighlights>



    @FormUrlEncoded
    @POST("newsDetails")
    fun getNewsdetails (
        @Field("userId") userId: String ,
        @Field("securityToken")securityToken: String ,
        @Field("versionName")versionName: String ,
        @Field("versionCode")versionCode: String ,
        @Field("newsId") newsId: String ) : Call<NewsDetails_2>


 }






