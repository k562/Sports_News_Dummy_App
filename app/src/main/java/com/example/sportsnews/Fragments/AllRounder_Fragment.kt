package com.example.sportsnews.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.sportsnews.AllRounder_pager
import com.example.sportsnews.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class AllRounder_Fragment : Fragment() {

        lateinit var tablyout7 : TabLayout
        lateinit var viewPager7 : ViewPager2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
       val view =   inflater.inflate(R.layout.fragment_all_rounder_, container, false)

        tablyout7 = view.findViewById(R.id.tabLayout7)
        viewPager7 = view.findViewById(R.id.view_pager7)

        val adapter = AllRounder_pager(childFragmentManager, lifecycle)
        viewPager7.adapter = adapter

        TabLayoutMediator(tablyout7, viewPager7) { tab, position ->
            when (position) {
                0 -> tab.text = "TEST"
                1 -> tab.text = "ODI"
                2 -> tab.text = "T20"
            }
        }.attach()

        return view
    }


}