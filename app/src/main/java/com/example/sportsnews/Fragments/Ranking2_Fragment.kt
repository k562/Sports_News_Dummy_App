package com.example.sportsnews.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.sportsnews.FragmentPager
import com.example.sportsnews.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class Ranking2_Fragment : Fragment() {

     lateinit var tabLayout3: TabLayout
     lateinit var viewPager3: ViewPager2


     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_ranking2_, container, false)

//        tabLayout3 = view.findViewById(R.id.tabLayout3)
//        viewPager3 = view.findViewById(R.id.view_pager3)

        val adapter = FragmentPager(childFragmentManager, lifecycle)
        viewPager3.adapter = adapter

        TabLayoutMediator(tabLayout3, viewPager3) { tab, position ->
            when (position) {
                0 -> tab.text = "TEAMS"
                1 -> tab.text = "BATTERS"
                2 -> tab.text = "BOWLERS"
                3 -> tab.text = "ALL ROUNDERS"
            }
        }.attach()

         return view
    }


}