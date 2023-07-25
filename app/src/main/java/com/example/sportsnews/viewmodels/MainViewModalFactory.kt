package com.example.sportsnews.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sportsnews.repository.NewsRepository

class MainViewModalFactory(private val repository: NewsRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return NewsMainViewModel(repository) as T
    }

}