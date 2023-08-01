package com.example.sportsnews.Fragments

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsnews.Adapter.Highlights_Adapter
import com.example.sportsnews.R
import com.example.sportsnews.Adapter.Report_Adapter
import com.example.sportsnews.models.NewsTrendingHighlights
import com.example.sportsnews.viewmodels.NewsMainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class NewsFragment : Fragment() {

        lateinit var recyclerviewReport : RecyclerView
        lateinit var reportAdapter : Report_Adapter
         var reportlist = ArrayList<NewsTrendingHighlights.NewsDetails.TrendingNew>()

        lateinit var recyclerviewHighlights : RecyclerView
        lateinit var highlightsAdapter : Highlights_Adapter
        var highlightslist = ArrayList<NewsTrendingHighlights.NewsDetails.Highlight>()

        lateinit var showmore1  : TextView
        lateinit var showmore2  : TextView
        lateinit var toolbarnews : Toolbar

        lateinit var newsTrendingHighlightsviewModel : NewsMainViewModel

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_news, container, false)

        toolbarnews = view.findViewById(R.id.Toolbarnews)


          updateUI()

        // Report RecyclerView

        recyclerviewReport = view.findViewById(R.id.recycler_viewReport)

        //Highlights RecyclerView

        recyclerviewHighlights = view.findViewById(R.id.recyclerViewHighlights)


        newsTrendingHighlightsviewModel = ViewModelProvider(this
        )[NewsMainViewModel::class.java]

        newsTrendingHighlightsviewModel.newstrendinghighlights(
            userID = "2",
            securityToken = "22",
            versionName = "12",
            versionCode = "11",

            newsCategory = "14"
        ) .observe(requireActivity(), Observer {


          if (it != null) {
          reportAdapter = Report_Adapter(requireContext() , it.newsDetails.trendingNews)

          }

            recyclerviewReport.adapter = reportAdapter
            reportAdapter.notifyDataSetChanged()
            recyclerviewReport.layoutManager = LinearLayoutManager(activity as Context, RecyclerView.HORIZONTAL , false)
            recyclerviewReport.setHasFixedSize(true) })


           newsTrendingHighlightsviewModel.newshighlights(

            userID = "2",
            securityToken = "22",
            versionName = "12",
            versionCode = "11",
            newsCategory = "14"


        ) .observe(requireActivity(), Observer {

            if (it != null) {
                highlightsAdapter = Highlights_Adapter(activity as Context , it.newsDetails.highlights)
            }
            recyclerviewHighlights.adapter = highlightsAdapter
            highlightsAdapter.notifyDataSetChanged()
            recyclerviewHighlights.layoutManager = LinearLayoutManager(activity as Context)
            recyclerviewHighlights.setHasFixedSize(true) })


            showmore1 = view.findViewById(R.id.showmore1)
            showmore2 = view.findViewById(R.id.showmore2)



        showmore1.setOnClickListener {
            val fragmentmanager = requireActivity().supportFragmentManager
            val transaction = fragmentmanager.beginTransaction()
            transaction.replace(R.id.Framelayout, NewsInfo())

            transaction.addToBackStack("NewsDetailFragment")
            transaction.commit()
        }

        showmore2.setOnClickListener {

            val fragmentmanager = requireActivity().supportFragmentManager
            val transaction = fragmentmanager.beginTransaction()
            transaction.replace(R.id.Framelayout, NewsInfo())

            transaction.addToBackStack("NewsDetailFragment")
            transaction.commit()
        }

        return  view


    }


    fun updateUI(){



        // Get a reference to the activity's window
        val window = requireActivity().window

// Set the status bar color
        window.statusBarColor = Color.parseColor("#03A9F4")

        // Get a reference to the toolbar
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.Toolbar)

// Set the toolbar background color
        toolbar.setBackgroundColor(Color.parseColor("#03A9F4"))

        // Hide the title
        toolbar.title = "News Details"



        // Hide the toolbar
        toolbar.visibility = View.GONE

        toolbarnews.title = "News Details"

        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.BottomNavigationView)

        // Hide the bottom navigation view
        bottomNavigationView?.visibility = View.VISIBLE
    }

   }