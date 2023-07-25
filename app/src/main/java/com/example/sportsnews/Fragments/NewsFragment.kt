package com.example.sportsnews.Fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsnews.Highlights_Adapter
import com.example.sportsnews.R
import com.example.sportsnews.Report_Adapter
import com.example.sportsnews.Report_Data_class
import com.example.sportsnews.highlights_data
import com.google.android.material.bottomnavigation.BottomNavigationView


class NewsFragment : Fragment() {

       lateinit var recyclerviewReport : RecyclerView
       lateinit var reportAdapter : Report_Adapter
         var reportlist = ArrayList<Report_Data_class>()

      lateinit var recyclerviewHighlights : RecyclerView
      lateinit var highlightsAdapter : Highlights_Adapter
      var highlightslist = ArrayList<highlights_data>()

    lateinit var showmore1  : TextView
    lateinit var showmore2  : TextView
    lateinit var toolbarnews : Toolbar

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view  = inflater.inflate(R.layout.fragment_news, container, false)

        toolbarnews = view.findViewById(R.id.Toolbarnews)

        // Get a reference to the activity's window
        val window = requireActivity().window

// Set the status bar color
        window.statusBarColor = Color.parseColor("#03A9F4")

        // Get a reference to the toolbar
        var toolbar = requireActivity().findViewById<Toolbar>(R.id.Toolbar)

// Set the toolbar background color
        toolbar.setBackgroundColor(Color.parseColor("#03A9F4"))

        // Hide the title
        toolbar.title = "News Details"

// Hide the options menu
//        toolbar.menu.clear()

        // Hide the toolbar
        toolbar.visibility = View.GONE

        toolbarnews.title = "News Details"




        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.BottomNavigationView)

        // Hide the bottom navigation view
        bottomNavigationView?.visibility = View.VISIBLE




        recyclerviewReport = view.findViewById(R.id.recycler_viewReport)
        recyclerviewReport.layoutManager = LinearLayoutManager(activity as Context, RecyclerView.HORIZONTAL , false)
        recyclerviewReport.setHasFixedSize(true)


        //Highlights RecyclerView

        recyclerviewHighlights = view.findViewById(R.id.recyclerViewHighlights)
        recyclerviewHighlights.layoutManager = LinearLayoutManager(activity as Context)
        recyclerviewHighlights.setHasFixedSize(true)



        reportlist.add(Report_Data_class(R.drawable.dhoni , "18k+ watched . 1 hour ago","The 2022 World Cup Be the Most memorable ..."))
        reportlist.add(Report_Data_class(R.drawable.dhoni , "18k+ watched . 1 hour ago","The 2022 World Cup Be the Most memorable ..."))
        reportlist.add(Report_Data_class(R.drawable.dhoni , "18k+ watched . 1 hour ago","The 2022 World Cup Be the Most memorable ..."))
        reportlist.add(Report_Data_class(R.drawable.dhoni , "18k+ watched . 1 hour ago","The 2022 World Cup Be the Most memorable ..."))
        reportlist.add(Report_Data_class(R.drawable.dhoni , "18k+ watched . 1 hour ago","The 2022 World Cup Be the Most memorable ..."))
        reportlist.add(Report_Data_class(R.drawable.dhoni , "18k+ watched . 1 hour ago","The 2022 World Cup Be the Most memorable ..."))
        reportlist.add(Report_Data_class(R.drawable.dhoni , "18k+ watched . 1 hour ago","The 2022 World Cup Be the Most memorable ..."))
        reportlist.add(Report_Data_class(R.drawable.dhoni , "18k+ watched . 1 hour ago","The 2022 World Cup Be the Most memorable ..."))
        reportlist.add(Report_Data_class(R.drawable.dhoni , "18k+ watched . 1 hour ago","The 2022 World Cup Be the Most memorable ..."))


        // Highlights add item list

        highlightslist.add(highlights_data(R.drawable.dhoni , "18k+ watched . 1 hour ago","18 Dec","Argentina success In \nWinning the 2022 World Cup ..."))
        highlightslist.add(highlights_data(R.drawable.dhoni , "18k+ watched . 1 hour ago","18 Dec","Argentina success In \nWinning the 2022 World Cup ..."))
        highlightslist.add(highlights_data(R.drawable.dhoni , "18k+ watched . 1 hour ago","18 Dec","Argentina success In \nWinning the 2022 World Cup ..."))
        highlightslist.add(highlights_data(R.drawable.dhoni , "18k+ watched . 1 hour ago","18 Dec","Argentina success In \nWinning the 2022 World Cup ..."))
        highlightslist.add(highlights_data(R.drawable.dhoni , "18k+ watched . 1 hour ago","18 Dec","Argentina success In \nWinning the 2022 World Cup ..."))
        highlightslist.add(highlights_data(R.drawable.dhoni , "18k+ watched . 1 hour ago","18 Dec","Argentina success In \nWinning the 2022 World Cup ..."))
        highlightslist.add(highlights_data(R.drawable.dhoni , "18k+ watched . 1 hour ago","18 Dec","Argentina success In \nWinning the 2022 World Cup ..."))
        highlightslist.add(highlights_data(R.drawable.dhoni , "18k+ watched . 1 hour ago","18 Dec","Argentina success In \nWinning the 2022 World Cup ..."))
        highlightslist.add(highlights_data(R.drawable.dhoni , "18k+ watched . 1 hour ago","18 Dec","Argentina success In \nWinning the 2022 World Cup ..."))
        highlightslist.add(highlights_data(R.drawable.dhoni , "18k+ watched . 1 hour ago","18 Dec","Argentina success In \nWinning the 2022 World Cup ..."))
        highlightslist.add(highlights_data(R.drawable.dhoni , "18k+ watched . 1 hour ago","18 Dec","Argentina success In \nWinning the 2022 World Cup ..."))
        highlightslist.add(highlights_data(R.drawable.dhoni , "18k+ watched . 1 hour ago","18 Dec","Argentina success In \nWinning the 2022 World Cup ..."))
        highlightslist.add(highlights_data(R.drawable.dhoni , "18k+ watched . 1 hour ago","18 Dec","Argentina success In \nWinning the 2022 World Cup ..."))


        reportAdapter = Report_Adapter(activity as Context , reportlist)
        recyclerviewReport.adapter = reportAdapter
        reportAdapter.notifyDataSetChanged()



        // Highlights Adapter

        highlightsAdapter = Highlights_Adapter(activity as Context , highlightslist)
        recyclerviewHighlights.adapter = highlightsAdapter
        highlightsAdapter.notifyDataSetChanged()





        showmore1 = view.findViewById(R.id.showmore1)
        showmore2 = view.findViewById(R.id.showmore2)



        showmore1.setOnClickListener {
            val fragmentmanager = requireActivity().supportFragmentManager
            val transaction = fragmentmanager.beginTransaction()
            transaction.replace(R.id.Framelayout, FragmentTab3())

            transaction.addToBackStack("NewsDetailFragment")
            transaction.commit()
        }

        showmore2.setOnClickListener {

            val fragmentmanager = requireActivity().supportFragmentManager
            val transaction = fragmentmanager.beginTransaction()
            transaction.replace(R.id.Framelayout, FragmentTab3())

            transaction.addToBackStack("NewsDetailFragment")
            transaction.commit()
        }







        return  view


    }


   }