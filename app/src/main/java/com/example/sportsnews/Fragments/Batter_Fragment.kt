package com.example.sportsnews.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.sportsnews.BatterPager
import com.example.sportsnews.BowlerPager
import com.example.sportsnews.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class Batter_Fragment : Fragment() {


   lateinit var tabLayout5: TabLayout
   lateinit var viewPager5: ViewPager2


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view =  inflater.inflate(R.layout.fragment_batter_, container, false)

        tabLayout5 = view.findViewById(R.id.tabLayout5)
        viewPager5 = view.findViewById(R.id.view_pager5)

        val adapter = BatterPager(childFragmentManager, lifecycle)
        viewPager5.adapter = adapter

        TabLayoutMediator(tabLayout5, viewPager5) { tab, position ->
            when (position) {
                0 -> tab.text = "TEST"
                1 -> tab.text = "ODI"
                2 -> tab.text = "T20"
            }
        }.attach()

        return view
    }


}