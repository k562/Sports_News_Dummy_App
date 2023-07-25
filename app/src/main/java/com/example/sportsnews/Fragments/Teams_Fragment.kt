package com.example.sportsnews.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.sportsnews.FragmentPager
import com.example.sportsnews.R
import com.example.sportsnews.TeamsPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class Teams_Fragment : Fragment() {

    lateinit var tablayout4 : TabLayout
    lateinit var viewpager4 : ViewPager2


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_teams_, container, false)

        tablayout4  = view.findViewById(R.id.tabLayout4)
        viewpager4 = view.findViewById(R.id.view_pager4)

        val adapter = TeamsPager(childFragmentManager, lifecycle)
        viewpager4.adapter = adapter

        TabLayoutMediator(tablayout4, viewpager4) { tab, position ->
            when (position) {
                0 -> tab.text = "TEST"
                1 -> tab.text = "ODI"
                2 -> tab.text = "T20"
            }
        }.attach()






        return view
    }


}