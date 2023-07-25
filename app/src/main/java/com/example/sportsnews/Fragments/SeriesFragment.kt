package com.example.sportsnews.Fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.example.sportsnews.Internationalpager_Adaper
import com.example.sportsnews.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class SeriesFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
//     val tabtitles = arrayListOf("INTERNATIONAL", "T20 LEAGUE", "DOMESTIC")

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view =   inflater.inflate(R.layout.fragment_series, container, false)


        tabLayout = view.findViewById(R.id.tabLayout2)
        viewPager = view.findViewById(R.id.view_pager2)

        viewPager.adapter = Internationalpager_Adaper(childFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
           when(position){

               0 -> tab.text = "Table"
               1 -> tab.text = "Schedule"

           }

        }.attach()





        // Get a reference to the toolbar
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.Toolbar)

// Set the toolbar background color
        toolbar.setBackgroundColor(Color.parseColor("#EFEBEB"))

        // Hide the title
        toolbar.title = ""

// Hide the options menu
//        toolbar.menu.clear()

        // Hide the toolbar
        toolbar.visibility = View.GONE


        val window = requireActivity().window
        // Set the status bar color
        window.statusBarColor = Color.parseColor("#03A9F4")



        return view
    }


}