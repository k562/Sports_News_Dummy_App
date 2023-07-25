package com.example.sportsnews.repository


import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


import com.example.sportsnews.api.apiInterface

import com.example.sportsnews.models.Newsdata




    class NewsRepository (private val apiInterface: apiInterface) {

        private val newsliveData = MutableLiveData<Newsdata>()

        val news: LiveData<Newsdata>
            get() = newsliveData

//        private val matchStatusLiveData = MutableLiveData<Matches>()
//        val matchStatus: LiveData<Matches>
//            get() = matchStatusLiveData

        suspend fun getNews(): Newsdata {


            try {
                val result = apiInterface.getheadlines("in", 1, "sports")
                newsliveData.postValue(result)
                return result
            } catch (e: Exception) {
                // Handle any errors or exceptions that might occur during the network call
                e.printStackTrace()
            }

            return Newsdata(0, ArrayList() )

        }

//        suspend fun getmatchstatus() {
//
//            try {
//                val resultStatus = apiInterface.matchstatus()
//                matchStatusLiveData.postValue(resultStatus)
//            } catch (e: Exception) {
//                // Handle any errors or exceptions that might occur during the network call
//                e.printStackTrace()
//
//            }
//        }
    }









