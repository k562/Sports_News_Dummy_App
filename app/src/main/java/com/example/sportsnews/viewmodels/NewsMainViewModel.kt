package com.example.sportsnews.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportsnews.models.Matches
import com.example.sportsnews.models.Newsdata
import com.example.sportsnews.models.newsdetails
import com.example.sportsnews.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsMainViewModel (private val repository: NewsRepository): ViewModel() {

    // Initialize newslist as MutableLiveData
    private val newsListLiveData = MutableLiveData<List<newsdetails>>()

    // Expose it as LiveData to the Fragment
    val newsList: LiveData<List<newsdetails>> get() = newsListLiveData




//   private val matchesliveData = MutableLiveData<List<Matches>>()

//    val matches : LiveData<List<Matches>>()


    init {

        viewModelScope.launch ( Dispatchers.IO ) {

            try {

                val result = repository.getNews()
                val newsData = result.articles
                newsListLiveData.postValue(newsData)
            } catch (e: Exception) {
                // Handle any errors or exceptions that might occur during the network call
                e.printStackTrace()
        }

        }
    }

    val news : LiveData<Newsdata>
        get() = repository.news

}