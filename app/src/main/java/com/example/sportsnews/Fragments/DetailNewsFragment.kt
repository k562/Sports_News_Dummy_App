package com.example.sportsnews.Fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.example.sportsnews.FragmentPager
import com.example.sportsnews.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class DetailNewsFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    lateinit var toolbar3 : Toolbar


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
                0 -> tab.text = "Info"
                1 -> tab.text = "News"

            }
        }.attach()

        // Get a reference to the bottom navigation view
        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.BottomNavigationView)

        // Hide the bottom navigation view
        bottomNavigationView?.visibility = View.GONE

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

     //    Hide the options menu
      //  toolbar.menu.clear()


        toolbar3 = view.findViewById(R.id.Toolbar3)

        toolbar3.menu.clear()
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar3)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.btn_back) // Replace with your back button icon
        }
        toolbar3.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        return view


    }







}