package com.example.sportsnews.repository


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sportsnews.api.RatrofitHelper

import com.example.sportsnews.models.Matchlist
import com.example.sportsnews.models.NewInfo
import com.example.sportsnews.models.NewsTrendingHighlights

import com.example.sportsnews.dummyModels.Newsdata
import com.example.sportsnews.models.NewsDetails_2
import com.example.sportsnews.models.UpcomingList
import retrofit2.Call
import retrofit2.Response


class NewsRepository() {


    // Live data newslist to hold the news data
    private val newsliveData = MutableLiveData<Newsdata>()

    val news: LiveData<Newsdata>
        get() = newsliveData


    val postMatchList = MutableLiveData<Matchlist?>()

    val postNewsList = MutableLiveData<Matchlist?>()

    val postUpcomingList = MutableLiveData<UpcomingList?>()

    val postNewsTrendingHighlights = MutableLiveData<NewsTrendingHighlights?>()

    val postNewsHighlights = MutableLiveData<NewsTrendingHighlights?>()

    val postNewsInfo = MutableLiveData<NewInfo?>()

    val postNewsDetails = MutableLiveData<NewsDetails_2?>()



    fun getMatchList(
        userId: String,

        securityToken: String,

        versionName: String,

        versionCode: String
    ): MutableLiveData<Matchlist?> {

        val call: retrofit2.Call<Matchlist> = RatrofitHelper.getMyApi().getMatchList(
            userId = userId,
            securityToken = securityToken,
            versionName = versionName,
            versionCode = versionCode
        )
        call.enqueue(object : retrofit2.Callback<Matchlist> {
            override fun onResponse(
                call: retrofit2.Call<Matchlist>,
                response: Response<Matchlist>
            ) {
                if (response.isSuccessful) {
                    val matchlist = response.body()
                    if (matchlist != null) {
                        postMatchList.postValue(matchlist)
                    } else {

                    }

                } else {
                    Log.d("MatchList", response.code().toString())
                    Log.d("MatchList_message", response.message().toString())

                }
            }

            override fun onFailure(call: retrofit2.Call<Matchlist>, t: Throwable) {

                Log.d("MatchlistError", t.message.toString())
            }

        })

        return postMatchList
    }





     fun getNewslist(
         userId: String,

         securityToken: String,

         versionName: String,

         versionCode: String
     ) : MutableLiveData<Matchlist?> {

         val call : retrofit2.Call<Matchlist> = RatrofitHelper.getMyApi().getNewslist(
             userId = userId,
             securityToken = securityToken,
             versionName =   versionName,
             versionCode =   versionCode )

         call.enqueue(object : retrofit2.Callback<Matchlist>{
             override fun onResponse(
                 call: retrofit2.Call<Matchlist>,
                 response: Response<Matchlist>
             ) {
                 if(response.isSuccessful){
                     val newslist = response.body()
                     if (newslist != null){
                         postNewsList.postValue(newslist)
                     } else {

                     }

                 } else {
                     Log.d("MatchList", response.code().toString())
                     Log.d("MatchList_message", response.message().toString())
                 }
             }

             override fun onFailure(call: retrofit2.Call<Matchlist>, t: Throwable) {

                 Log.d("NewslistError", t.message.toString())
             }
         })

         return postNewsList


     }



    fun getUpcominglist(
        userId: String,
        securityToken: String,
        versionName: String,
        versionCode: String
    ) : MutableLiveData<UpcomingList?>{

        val call : retrofit2.Call<UpcomingList> = RatrofitHelper.getMyApi().getupcominglist(
            userId = userId,
            securityToken = securityToken,
            versionName = versionName,
            versionCode = versionCode )

        call.enqueue(object : retrofit2.Callback<UpcomingList>{
            override fun onResponse(
                call: retrofit2.Call<UpcomingList>,
                response: Response<UpcomingList>
            ) {
                if(response.isSuccessful){
                    val upcominglist = response.body()
                    if (upcominglist != null){
                        postUpcomingList.postValue(upcominglist)
                    } else {

                    }

                } else {
                    Log.d("Upcominglist", response.code().toString())
                    Log.d("Upcominglist_message", response.message().toString())
                }
            }

            override fun onFailure(call: retrofit2.Call<UpcomingList>, t: Throwable) {

                Log.d("UpcominglistError", t.message.toString())
            }
        })
        return postUpcomingList
    }



    fun getNewsTrendinghighlights(
        userId: String,
        securityToken: String,
        versionName: String,
        versionCode: String,

        newsCategory : String
    ) : MutableLiveData<NewsTrendingHighlights?>{

       val call : retrofit2.Call<NewsTrendingHighlights> = RatrofitHelper.getMyApi().getNewsTrendingHighlights(
           userId = userId,
           securityToken = securityToken,
           versionName = versionName,
           versionCode = versionCode ,

           newsCategory = newsCategory
       )
        call.enqueue(object : retrofit2.Callback<NewsTrendingHighlights>{
            override fun onResponse(
                call: retrofit2.Call<NewsTrendingHighlights>,
                response: Response<NewsTrendingHighlights>
            ) {
                if  (response.isSuccessful){
                    val newstrendinghighlights = response.body()
                    if (newstrendinghighlights != null){
                        postNewsTrendingHighlights.postValue(newstrendinghighlights)
                    } else {

                    }

                } else {
                    Log.d("NewsHighlights", response.code().toString())
                    Log.d("NewsTrendingHighlights_message", response.message().toString())
                }
            }

            override fun onFailure(call: retrofit2.Call<NewsTrendingHighlights>, t: Throwable) {

                Log.d("NewsTrendingHighlightsError", t.message.toString())
            }
        })
        return postNewsTrendingHighlights
    }


    fun getNewsHighlights(
        userId: String,
        securityToken: String,
        versionName: String,
        versionCode: String,

        newsCategory : String
    ) : MutableLiveData<NewsTrendingHighlights?>{

        val call : retrofit2.Call<NewsTrendingHighlights> = RatrofitHelper.getMyApi().getNewsHighlights(
            userId = userId,
            securityToken = securityToken,
            versionName = versionName,
            versionCode = versionCode ,
//            newsId = newsId,
            newsCategory = newsCategory
        )
        call.enqueue(object : retrofit2.Callback<NewsTrendingHighlights>{
            override fun onResponse(
                call: retrofit2.Call<NewsTrendingHighlights>,
                response: Response<NewsTrendingHighlights>
            ) {
                if  (response.isSuccessful){
                    val newshighlights = response.body()
                    if (newshighlights != null){
                        postNewsHighlights.postValue(newshighlights)
                    } else {

                    }

                } else {
                    Log.d("NewsHighlights", response.code().toString())
                    Log.d("NewsHighlights_message", response.message().toString())
                }
            }

            override fun onFailure(call: retrofit2.Call<NewsTrendingHighlights>, t: Throwable) {

                Log.d("NewsHighlightsError", t.message.toString())
            }
        })
        return postNewsHighlights
    }






    fun getNewsInfo(
        userId: String,
        securityToken: String,
        versionName: String,
        versionCode: String,
        newsId : String,
        newsCategory : String
    ): MutableLiveData<NewInfo?>{

        val call : retrofit2.Call<NewInfo> = RatrofitHelper.getMyApi().getnewsInfo(
            userId = userId,
            securityToken = securityToken,
            versionName = versionName,
            versionCode = versionCode,
            newsId = newsId,
            newsCategory = newsCategory
        )
        call.enqueue(object: retrofit2.Callback<NewInfo>{

            override fun onResponse(call: retrofit2.Call<NewInfo>, response: Response<NewInfo>) {

                if (response.isSuccessful){
                    val newsinfo = response.body()
                    if (newsinfo != null){
                        postNewsInfo.postValue(newsinfo)
                    } else {

                    }

                } else {
                    Log.d("NewsInfo", response.code().toString())
                    Log.d("NewsInfo_message", response.message().toString())
                }
            }

            override fun onFailure(call: retrofit2.Call<NewInfo>, t: Throwable) {
                Log.d("NewsInfo", t.message.toString())
            }
        })

        return postNewsInfo

    }



    fun getNewsDetails(
        userId: String,
        securityToken: String,
        versionName: String,
        versionCode: String ,
        newsId: String
    ) :MutableLiveData<NewsDetails_2?>{

        val call : retrofit2.Call<NewsDetails_2> = RatrofitHelper.getMyApi().getNewsdetails(
            userId = userId,
            securityToken = securityToken,
            versionName = versionName,
            versionCode = versionCode,
            newsId = newsId )

        call.enqueue(object : retrofit2.Callback<NewsDetails_2>{


            override fun onResponse(call: Call<NewsDetails_2>, response: Response<NewsDetails_2>) {

                if(response.isSuccessful){
                    val newsdetails = response.body()
                    if (newsdetails != null){
                        postNewsDetails.postValue(newsdetails)
                    } else {

                    }

                } else {
                    Log.d("NewsDetails", response.code().toString())
                    Log.d("NewsDetails_message", response.message().toString())
                }
            }

            override fun onFailure(call: Call<NewsDetails_2>, t: Throwable) {

                    Log.d("NewsDetailsError", t.message.toString())
            }
        })

        return postNewsDetails
    }




}














