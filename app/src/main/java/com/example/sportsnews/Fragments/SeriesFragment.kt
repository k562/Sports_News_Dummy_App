package com.example.sportsnews.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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

               0 -> tab.text = "INTERNATIONAL"
               1 -> tab.text = "T20 LEAGUE"
               2 -> tab.text = "DOMESTIC"
           }

        }.attach()

        for(i in 0 ..3){

            val textView = LayoutInflater.from(requireContext()).inflate(R.layout.tab_title, null) as TextView
            tabLayout.getTabAt(i)?.customView = textView
        }



        return view
    }


}