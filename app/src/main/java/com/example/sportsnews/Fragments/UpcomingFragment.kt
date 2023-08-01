package com.example.sportsnews.Fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsnews.R
import com.example.sportsnews.Adapter.UpcomingAdapter
import com.example.sportsnews.models.UpcomingList
import com.example.sportsnews.viewmodels.NewsMainViewModel


class UpcomingFragment : Fragment() {

      lateinit var upcomingrecycler : RecyclerView
      lateinit var UpcomingAdapter : UpcomingAdapter
      lateinit var toolbarupcoming : Toolbar
      var upcominglist = ArrayList<UpcomingList.UpcomingMatche>()


      lateinit var upcomingviewModel: NewsMainViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_upcoming, container, false)
       toolbarupcoming = view.findViewById(R.id.Toolbarupcoming)

       updateUI()

        upcomingviewModel = ViewModelProvider(this
        )[NewsMainViewModel::class.java]

        upcomingrecycler = view.findViewById(R.id.upcoming_recycler)

        upcomingviewModel.upcominglist(
            userId = "2",
            securityToken = "22",
            versionName = "12",
            versionCode = "11"
        ).observe(requireActivity(), Observer {

            if (it != null) {
                UpcomingAdapter = UpcomingAdapter(requireContext() , it.upcomingMatches)
            }
            UpcomingAdapter.notifyDataSetChanged()
            upcomingrecycler.layoutManager = LinearLayoutManager(activity as Context)
            upcomingrecycler.setHasFixedSize(true)
            upcomingrecycler.adapter = UpcomingAdapter


        })

        return view
    }




    fun updateUI (){
        // Get a reference to the toolbar
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.Toolbar)

       // Set the toolbar background color
        toolbar.setBackgroundColor(Color.parseColor("#03A9F4"))

        // Hide the title
        toolbar.title = "Upcoming"

        // Hide the toolbar
        toolbar.visibility = View.GONE


        toolbarupcoming.title = "Upcoming Matches"

        val window = requireActivity().window
        // Set the status bar color
        window.statusBarColor = Color.parseColor("#03A9F4")

    }


}