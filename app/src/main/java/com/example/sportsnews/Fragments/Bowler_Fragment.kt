package com.example.sportsnews.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.sportsnews.BowlerPager
import com.example.sportsnews.FragmentPager
import com.example.sportsnews.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class Bowler_Fragment : Fragment() {


    lateinit var tabLayout6: TabLayout
    lateinit var viewPager6: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view =  inflater.inflate(R.layout.fragment_bowler_, container, false)

        tabLayout6 = view.findViewById(R.id.tabLayout6)
        viewPager6 = view.findViewById(R.id.view_pager6)

        val adapter = BowlerPager(childFragmentManager, lifecycle)
        viewPager6.adapter = adapter

        TabLayoutMediator(tabLayout6, viewPager6) { tab, position ->
            when (position) {
                0 -> tab.text = "TEST"
                1 -> tab.text = "ODI"
                2 -> tab.text = "T20"
            }
        }.attach()

        return view
    }


}