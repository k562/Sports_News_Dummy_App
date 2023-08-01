package com.example.sportsnews.Fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsnews.Adapter.NewsInfo_Adapter
import com.example.sportsnews.R
import com.example.sportsnews.models.NewInfo
import com.example.sportsnews.viewmodels.NewsMainViewModel


class NewsInfo : Fragment() {

      lateinit var rec : RecyclerView
      lateinit var adapter : NewsInfo_Adapter
      var newslist = ArrayList<NewInfo.New>()
      private lateinit var progressBarLayout: View

      lateinit var newsInfoviewModel: NewsMainViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view =  inflater.inflate(R.layout.newsinfo, container, false)

        rec = view.findViewById(R.id.recycler_newlist)

        // Find the progress bar layout
        progressBarLayout = view.findViewById(R.id.progressLayout)


        // Set the visibility of the progress bar layout to visible initially
        progressBarLayout.visibility = View.VISIBLE

        // Set the background color of the root layout to white
        view.setBackgroundColor(Color.WHITE)

        newsInfoviewModel = ViewModelProvider(this
        )[NewsMainViewModel::class.java]


        newsInfoviewModel.newsinfo(
            userID = "2",
            securityToken = "22",
            versionName = "12",
            versionCode = "11",
            newsId = "",
            newsCategory = ""
        ) .observe(requireActivity(), Observer {


            if (it != null) {
                progressBarLayout.visibility = View.GONE
                adapter = NewsInfo_Adapter(requireContext(), it.news)
            }
            adapter.notifyDataSetChanged()
            rec.layoutManager = LinearLayoutManager(activity as Context)
            rec.setHasFixedSize(true)
            rec.adapter = adapter   })


            return view

    }



   }