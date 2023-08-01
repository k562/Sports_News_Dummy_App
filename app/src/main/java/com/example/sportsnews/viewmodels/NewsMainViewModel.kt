package com.example.sportsnews.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.sportsnews.models.Matchlist
import com.example.sportsnews.models.NewInfo
import com.example.sportsnews.models.NewsDetails_2
import com.example.sportsnews.models.NewsTrendingHighlights
import com.example.sportsnews.models.UpcomingList
import com.example.sportsnews.repository.NewsRepository

class NewsMainViewModel (application: Application): AndroidViewModel(application) {

   var repository : NewsRepository? = null

    init{
        repository = NewsRepository()
    }


    fun matchlist(
             userID : String ,
             versionName : String ,
             versionCode : String ,
             securityToken : String
         ) :MutableLiveData<Matchlist?> {

           return repository!!.getMatchList (
               userID,
               versionName,
               versionCode,
               securityToken  ) }


      fun newslist(
          userID : String ,
          versionName : String ,
          versionCode : String ,
          securityToken : String
      ) : MutableLiveData<Matchlist?>{


          return repository!!.getNewslist(
              userID,
              securityToken,
              versionName,
              versionCode,  ) }

    fun upcominglist(
        userId : String ,
        versionName : String ,
        versionCode : String ,
        securityToken : String
    ) : MutableLiveData<UpcomingList?>{

        return repository!!.getUpcominglist(
            userId,
            versionName,
            versionCode,
            securityToken, )}


    fun newstrendinghighlights(
        userID : String ,
        versionName : String ,
        versionCode : String ,
        securityToken : String,

        newsCategory : String,
    ) : MutableLiveData<NewsTrendingHighlights?>{

        return repository!!.getNewsTrendinghighlights(
            userID,
            securityToken,
            versionName,
            versionCode,

            newsCategory ) }

    fun newshighlights(
        userID : String ,
        versionName : String ,
        versionCode : String ,
        securityToken : String,

        newsCategory : String,
    ) : MutableLiveData<NewsTrendingHighlights?>{

        return repository!!.getNewsHighlights(
            userID,
            securityToken,
            versionName,
            versionCode,
            newsCategory ) }

    fun newsinfo(
        userID : String ,
        versionName : String ,
        versionCode : String ,
        securityToken : String,
        newsId : String,
        newsCategory : String,
    ) : MutableLiveData<NewInfo?>{

        return repository!!.getNewsInfo(
            userID,
            securityToken,
            versionName,
            versionCode,
            newsId,
            newsCategory ) }


    fun newsDetails (
        userId : String ,
        versionName : String ,
        versionCode : String ,
        securityToken : String,
        newsId: String

    ) : MutableLiveData<NewsDetails_2?>{

        return repository!!.getNewsDetails(
            userId,
            securityToken,
            versionName,
            versionCode,
            newsId) }

}