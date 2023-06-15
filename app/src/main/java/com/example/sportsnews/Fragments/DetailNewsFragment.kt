package com.example.sportsnews.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.sportsnews.FragmentPager
import com.example.sportsnews.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class DetailNewsFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail_news, container, false)

        tabLayout = view.findViewById(R.id.tab_layout)
        viewPager = view.findViewById(R.id.view_pager)

        tabLayout = view.findViewById(R.id.tab_layout)
        viewPager = view.findViewById(R.id.view_pager)

        val adapter = FragmentPager(childFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "LIVE"
                1 -> tab.text = "INFO"
                2 -> tab.text = "NEWS"
            }
        }.attach()

        // Get a reference to the bottom navigation view
        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.BottomNavigationView)

        // Hide the bottom navigation view
        bottomNavigationView?.visibility = View.GONE

        return view


    }


}