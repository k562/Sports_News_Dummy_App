package com.example.sportsnews.Fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsnews.NewsInfo_Adapter
import com.example.sportsnews.models.Newsdata
import com.example.sportsnews.R
import com.example.sportsnews.api.RatrofitHelper
import com.example.sportsnews.api.apiInterface
import com.example.sportsnews.models.newsdetails
import com.example.sportsnews.repository.NewsRepository
import com.example.sportsnews.viewmodels.MainViewModalFactory
import com.example.sportsnews.viewmodels.NewsMainViewModel


class FragmentTab3 : Fragment() {

      lateinit var rec : RecyclerView
      lateinit var adapter : NewsInfo_Adapter
      var newslist = ArrayList<newsdetails>()
      private lateinit var progressBarLayout: View
      lateinit var mainViewModel: NewsMainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view =  inflater.inflate(R.layout.fragment_tab3, container, false)

            rec = view.findViewById(R.id.recycler_newlist)
            rec.layoutManager = LinearLayoutManager(activity as Context)
            rec.setHasFixedSize(true)

            // Initialize the adapter and RecyclerView here, just once
           adapter = NewsInfo_Adapter(activity as Context, newslist)
           rec.adapter = adapter
           rec.layoutManager = LinearLayoutManager(activity as Context)
           rec.setHasFixedSize(true)



        // Find the progress bar layout
        progressBarLayout = view.findViewById(R.id.progressLayout)


        // Set the visibility of the progress bar layout to visible initially
        progressBarLayout.visibility = View.VISIBLE

        // Set the background color of the root layout to white
        view.setBackgroundColor(Color.WHITE)


        val newsinterface = RatrofitHelper.getInstance().create(apiInterface :: class.java)

        val repository =  NewsRepository(newsinterface)

        mainViewModel = ViewModelProvider(this,MainViewModalFactory(repository)).get(NewsMainViewModel :: class.java)


        // Observe the newsList LiveData in the ViewModel
        mainViewModel.newsList.observe(requireActivity(), Observer { newsData ->
            // Update the newslist with the new data
            newslist.clear()
            newslist.addAll(newsData)
            adapter.notifyDataSetChanged()

            // Hide the progress bar layout
            progressBarLayout.visibility = View.GONE
            // Set the background color of the root layout to white
            view.setBackgroundColor(Color.WHITE)
        })

        return view

    }



   }