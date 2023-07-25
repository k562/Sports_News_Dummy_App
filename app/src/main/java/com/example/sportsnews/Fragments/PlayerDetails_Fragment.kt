package com.example.sportsnews.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.sportsnews.PlayerDetails_Pager
import com.example.sportsnews.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class PlayerDetails_Fragment : Fragment() {


    lateinit var tablayout8 : TabLayout
    lateinit var viewpager8 : ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_player_details_, container, false)


        tablayout8 = view.findViewById(R.id.tab_layout8)
        viewpager8 = view.findViewById(R.id.view_pager8)


        val adapter = PlayerDetails_Pager(childFragmentManager, lifecycle)
        viewpager8.adapter = adapter

        TabLayoutMediator(tablayout8, viewpager8) { tab, position ->
            when (position) {

                0 -> tab.text = "INFO"
                1 -> tab.text = "BATTING"
                2 -> tab.text = "BOWLING"

            }
        }.attach()



        return view
    }


}