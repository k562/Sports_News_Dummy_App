package com.example.sportsnews.Fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
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
import com.example.sportsnews.Adapter.NewsAdapter
import com.example.sportsnews.R
import com.example.sportsnews.Adapter.latest_newsAdapter
import com.example.sportsnews.models.Matchlist

import com.example.sportsnews.viewmodels.NewsMainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class live_Fragment : Fragment() {


    lateinit var rec: RecyclerView
    lateinit var adapter2: NewsAdapter
    var listofnews = ArrayList<Matchlist.SportsNews.MatchesData>()

    lateinit var recycler_latesnews : RecyclerView
    lateinit var latestnews_Adapter : latest_newsAdapter
    var latestnewsdata = ArrayList<Matchlist.SportsNews.LatestNew>()

    lateinit var viewAll : TextView

    lateinit var liveviewModel: NewsMainViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_live_, container, false)

        updateUI()

        rec = view.findViewById(R.id.recycler_view)

        recycler_latesnews = view.findViewById(R.id.recycler_latest_news)


        viewAll = view.findViewById(R.id.ViewAll)

        // Initialize the ViewModel using the ViewModelFactory

        liveviewModel = ViewModelProvider(this
        )[NewsMainViewModel::class.java]

        liveviewModel.matchlist(
            userID = "2",
            securityToken = "22",
            versionName = "12",
            versionCode = "11"
        ).observe(requireActivity(), Observer {

            if (it != null) {


                rec.apply {
                    adapter2 = NewsAdapter(requireContext(), it.sportsNews.matchesData)
                    layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                    adapter=adapter2
                    setHasFixedSize(true)


                }
            }
        })

        liveviewModel.newslist(
            userID = "2" ,
            securityToken = "22",
            versionName = "12",
            versionCode = "11"

        ).observe(requireActivity() , Observer {

            if (it != null) {
                latestnews_Adapter = latest_newsAdapter(requireContext(), it.sportsNews.latestNews)
            }

            latestnews_Adapter.notifyDataSetChanged()
            recycler_latesnews.layoutManager = LinearLayoutManager(activity as Context)
            recycler_latesnews.setHasFixedSize(true)
            recycler_latesnews.adapter = latestnews_Adapter


        })


        viewAll.setOnClickListener {

                    val fragmentmanager = requireActivity().supportFragmentManager
                    val transaction = fragmentmanager.beginTransaction()
                    transaction.replace(R.id.Framelayout, NewsInfo())
                    transaction.addToBackStack("NewsDetailFragment")
                    transaction.commit()
                }


        return view


    }


    fun updateUI(){
        // Get a reference to the bottom navigation view
        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.BottomNavigationView)

        // Hide the bottom navigation view
        bottomNavigationView?.visibility = View.VISIBLE

        val window = requireActivity().window

        // Get a reference to the toolbar
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.Toolbar)

        // Set the toolbar background color
        toolbar.setBackgroundColor(Color.parseColor("#03A9F4"))

        // Set the status bar color
        window.statusBarColor = Color.parseColor("#03A9F4")


        // Hide the toolbar
        toolbar.visibility = View.VISIBLE

        toolbar.title = "Sports News"
    }
}







