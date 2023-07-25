package com.example.sportsnews.Fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsnews.R
import com.example.sportsnews.UpcomingAdapter
import com.example.sportsnews.upcomingData


class UpcomingFragment : Fragment() {

      lateinit var upcomingrecycler : RecyclerView
      lateinit var UpcomingAdapter : UpcomingAdapter
      lateinit var toolbarupcoming : Toolbar
      var upcominglist = ArrayList<upcomingData>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_upcoming, container, false)

        upcomingrecycler = view.findViewById(R.id.upcoming_recycler)
        upcomingrecycler.layoutManager = LinearLayoutManager(activity as Context)
        upcomingrecycler.setHasFixedSize(true)

        // Get a reference to the toolbar
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.Toolbar)

// Set the toolbar background color
        toolbar.setBackgroundColor(Color.parseColor("#03A9F4"))

        // Hide the title
        toolbar.title = "Upcoming"

// Hide the options menu
//        toolbar.menu.clear()

        // Hide the toolbar
        toolbar.visibility = View.GONE
        toolbarupcoming = view.findViewById(R.id.Toolbarupcoming)

        toolbarupcoming.title = "Upcoming Matches"

        val window = requireActivity().window
        // Set the status bar color
        window.statusBarColor = Color.parseColor("#03A9F4")




        upcominglist.add(upcomingData("Match 44 . ECS Sweden" , R.drawable.france , "France" , R.drawable.us , "Argentina" , "Today" , "7:00 PM"))
        upcominglist.add(upcomingData("Match 44 . ECS Sweden" , R.drawable.france , "France" , R.drawable.us , "Argentina" , "Today" , "7:00 PM"))
        upcominglist.add(upcomingData("Match 44 . ECS Sweden" , R.drawable.france , "France" , R.drawable.us , "Argentina" , "Today" , "7:00 PM"))
        upcominglist.add(upcomingData("Match 44 . ECS Sweden" , R.drawable.france , "France" , R.drawable.us , "Argentina" , "Today" , "7:00 PM"))
        upcominglist.add(upcomingData("Match 44 . ECS Sweden" , R.drawable.france , "France" , R.drawable.us , "Argentina" , "Today" , "7:00 PM"))
        upcominglist.add(upcomingData("Match 44 . ECS Sweden" , R.drawable.france , "France" , R.drawable.us , "Argentina" , "Today" , "7:00 PM"))
        upcominglist.add(upcomingData("Match 44 . ECS Sweden" , R.drawable.france , "France" , R.drawable.us , "Argentina" , "Today" , "7:00 PM"))
        upcominglist.add(upcomingData("Match 44 . ECS Sweden" , R.drawable.france , "France" , R.drawable.us , "Argentina" , "Today" , "7:00 PM"))



        UpcomingAdapter = UpcomingAdapter(activity as Context , upcominglist)
        upcomingrecycler.adapter = UpcomingAdapter
        UpcomingAdapter.notifyDataSetChanged()



       return view
    }


}