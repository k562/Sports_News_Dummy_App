package com.example.sportsnews.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.sportsnews.News
import com.example.sportsnews.NewsAdapter
import com.example.sportsnews.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class live_Fragment : Fragment() {

    lateinit var imageSlider: ImageSlider
    lateinit var rec : RecyclerView
    lateinit var adapter: NewsAdapter
  ///  lateinit var bottomNavigationView: BottomNavigationView
    var listofnews = arrayListOf<News>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val view =  inflater.inflate(R.layout.fragment_live_, container, false)

       rec = view.findViewById(R.id.recycler_view)
       rec.setHasFixedSize(true)
       rec.layoutManager = LinearLayoutManager(activity as Context)


        // Get a reference to the bottom navigation view
        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.BottomNavigationView)

        // Hide the bottom navigation view
       bottomNavigationView?.visibility = View.VISIBLE


        listofnews.add(News("* Live", "Usa tour of Ind 2023", R.drawable.notification, R.drawable.india,"IND","46h:45m","USA",R.drawable.india,"TABLE","SCHEDULE" ))
        listofnews.add(News("* Live", "Usa tour of Ind 2023", R.drawable.notification, R.drawable.india,"IND","46h:45m","USA",R.drawable.india,"TABLE","SCHEDULE" ))
        listofnews.add(News("* Live", "Usa tour of Ind 2023", R.drawable.notification, R.drawable.india,"IND","46h:45m","USA",R.drawable.india,"TABLE","SCHEDULE" ))
        listofnews.add(News("* Live", "Usa tour of Ind 2023", R.drawable.notification, R.drawable.india,"IND","46h:45m","USA",R.drawable.india,"TABLE","SCHEDULE" ))
        listofnews.add(News("* Live", "Usa tour of Ind 2023", R.drawable.notification, R.drawable.india,"IND","46h:45m","USA",R.drawable.india,"TABLE","SCHEDULE" ))
        listofnews.add(News("* Live", "Usa tour of Ind 2023", R.drawable.notification, R.drawable.india,"IND","46h:45m","USA",R.drawable.india,"TABLE","SCHEDULE" ))
        listofnews.add(News("* Live", "Usa tour of Ind 2023", R.drawable.notification, R.drawable.india,"IND","46h:45m","USA",R.drawable.india,"TABLE","SCHEDULE" ))
        listofnews.add(News("* Live", "Usa tour of Ind 2023", R.drawable.notification, R.drawable.india,"IND","46h:45m","USA",R.drawable.india,"TABLE","SCHEDULE" ))
        listofnews.add(News("* Live", "Usa tour of Ind 2023", R.drawable.notification, R.drawable.india,"IND","46h:45m","USA",R.drawable.india,"TABLE","SCHEDULE" ))
        listofnews.add(News("* Live", "Usa tour of Ind 2023", R.drawable.notification, R.drawable.india,"IND","46h:45m","USA",R.drawable.india,"TABLE","SCHEDULE" ))
        listofnews.add(News("* Live", "Usa tour of Ind 2023", R.drawable.notification, R.drawable.india,"IND","46h:45m","USA",R.drawable.india,"TABLE","SCHEDULE" ))
        listofnews.add(News("* Live", "Usa tour of Ind 2023", R.drawable.notification, R.drawable.india,"IND","46h:45m","USA",R.drawable.india,"TABLE","SCHEDULE" ))
        listofnews.add(News("* Live", "Usa tour of Ind 2023s", R.drawable.notification, R.drawable.india,"IND","46h:45m","USA",R.drawable.india,"TABLE","SCHEDULE" ))
        listofnews.add(News("* Live", "Usa tour of Ind 2023", R.drawable.notification, R.drawable.india,"IND","46h:45m","USA",R.drawable.india,"TABLE","SCHEDULE" ))
        listofnews.add(News("* Live", "Usa tour of Ind 2023", R.drawable.notification, R.drawable.india,"IND","46h:45m","USA",R.drawable.india,"TABLE","SCHEDULE" ))
        listofnews.add(News("* Live", "Usa tour of Ind 2023", R.drawable.notification, R.drawable.india,"IND","46h:45m","USA",R.drawable.india,"TABLE","SCHEDULE" ))


         adapter = NewsAdapter(activity as Context , listofnews)
         rec.adapter = adapter
         adapter.notifyDataSetChanged()



        imageSlider = view.findViewById(R.id.ImageSlider)

        sliderImage()

      return view


    }

    private fun sliderImage() {

        val  imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.ball))
        imageList.add(SlideModel(R.drawable.bat))
        imageList.add(SlideModel(R.drawable.cricket))
        imageList.add(SlideModel(R.drawable.wicket))

        imageSlider.setImageList(imageList, ScaleTypes.FIT)
    }



}


