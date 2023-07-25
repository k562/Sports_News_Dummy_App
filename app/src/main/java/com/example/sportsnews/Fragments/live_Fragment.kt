package com.example.sportsnews.Fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsnews.ListMatch
import com.example.sportsnews.NewsAdapter
import com.example.sportsnews.R
import com.example.sportsnews.latest_newsAdapter
import com.example.sportsnews.latest_news_data
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Callback
import retrofit2.Response


class live_Fragment : Fragment() {

  //  private var mActivity: FragmentActivity? = null
 //   lateinit var imageSlider: ImageSlider
    lateinit var rec: RecyclerView
    lateinit var adapter2: NewsAdapter
    var listofnews = ArrayList<ListMatch>()

    lateinit var recycler_latesnews : RecyclerView
    lateinit var latestnews_Adapter : latest_newsAdapter
    var latestnewsdata = ArrayList<latest_news_data>()

    lateinit var viewAll : TextView
//    private var fragmentContext: Context? = null


//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//
//        fragmentContext = context
//
//        if (context is FragmentActivity) {
//            mActivity = context
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        fragmentContext = null
//    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_live_, container, false)

        rec = view.findViewById(R.id.recycler_view)
        rec.setHasFixedSize(true)
        rec.layoutManager = LinearLayoutManager(activity as Context)


        // Get a reference to the bottom navigation view
       val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.BottomNavigationView)

        // Hide the bottom navigation view
        bottomNavigationView?.visibility = View.VISIBLE

        val window = requireActivity().window

        // Get a reference to the toolbar
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.Toolbar)

// Set the toolbar background color
        toolbar.setBackgroundColor(Color.parseColor("#03A9F4"))

// Set the status bar color
        window.statusBarColor = Color.parseColor("#03A9F4")


        // Hide the toolbar
        toolbar.visibility = View.VISIBLE

        toolbar.title = "Sports News"

        viewAll = view.findViewById(R.id.ViewAll)


        listofnews.add(ListMatch("Semi Final-World Cup","France",R.drawable.france,"3-0","15 Dec","Argentina",R.drawable.argentina))
        listofnews.add(ListMatch("Semi Final-World Cup","France",R.drawable.france,"3-0","15 Dec","Argentina",R.drawable.argentina))
        listofnews.add(ListMatch("Semi Final-World Cup","France",R.drawable.france,"3-0","15 Dec","Argentina",R.drawable.argentina))
        listofnews.add(ListMatch("Semi Final-World Cup","France",R.drawable.france,"3-0","15 Dec","Argentina",R.drawable.argentina))
        listofnews.add(ListMatch("Semi Final-World Cup","France",R.drawable.france,"3-0","15 Dec","Argentina",R.drawable.argentina))
        listofnews.add(ListMatch("Semi Final-World Cup","France",R.drawable.france,"3-0","15 Dec","Argentina",R.drawable.argentina))
        listofnews.add(ListMatch("Semi Final-World Cup","France",R.drawable.france,"3-0","15 Dec","Argentina",R.drawable.argentina))
        listofnews.add(ListMatch("Semi Final-World Cup","France",R.drawable.france,"3-0","15 Dec","Argentina",R.drawable.argentina))
        listofnews.add(ListMatch("Semi Final-World Cup","France",R.drawable.france,"3-0","15 Dec","Argentina",R.drawable.argentina))
        listofnews.add(ListMatch("Semi Final-World Cup","France",R.drawable.france,"3-0","15 Dec","Argentina",R.drawable.argentina))
        listofnews.add(ListMatch("Semi Final-World Cup","France",R.drawable.france,"3-0","15 Dec","Argentina",R.drawable.argentina))
        listofnews.add(ListMatch("Semi Final-World Cup","France",R.drawable.france,"3-0","15 Dec","Argentina",R.drawable.argentina))




         adapter2 = NewsAdapter(activity as Context , listofnews)
         rec.adapter = adapter2
         adapter2.notifyDataSetChanged()




        recycler_latesnews = view.findViewById(R.id.recycler_latest_news)
        recycler_latesnews.layoutManager = LinearLayoutManager(activity as Context)
        recycler_latesnews.setHasFixedSize(true)



        latestnewsdata.add(latest_news_data(R.drawable.dhoni,"Goball.net","Argenttina success in winning the 2022 world cup"))
        latestnewsdata.add(latest_news_data(R.drawable.dhoni,"Goball.net","Argenttina success in winning the 2022 world cup"))
        latestnewsdata.add(latest_news_data(R.drawable.dhoni,"Goball.net","Argenttina success in winning the 2022 world cup"))
        latestnewsdata.add(latest_news_data(R.drawable.dhoni,"Goball.net","Argenttina success in winning the 2022 world cup"))


        latestnews_Adapter =  latest_newsAdapter (activity as Context , latestnewsdata)
        recycler_latesnews.adapter = latestnews_Adapter
        latestnews_Adapter.notifyDataSetChanged()
















       // imageSlider = view.findViewById(R.id.ImageSlider)

      //  sliderImage2()
        //   getLiveNews()

        viewAll.setOnClickListener {

                val fragmentmanager = requireActivity().supportFragmentManager
                val transaction = fragmentmanager.beginTransaction()
                transaction.replace(R.id.Framelayout , FragmentTab3())

                transaction.addToBackStack("NewsDetailFragment")
                transaction.commit()
        }
        return view


    }

//    private fun sliderImage2() {
//        val imageList = ArrayList<SlideModel>()
//        imageList.add(SlideModel(R.drawable.img1))
//        imageList.add(SlideModel(R.drawable.img2))
//        imageList.add(SlideModel(R.drawable.img3))
//        imageList.add(SlideModel(R.drawable.img4))
//
//        imageSlider.setImageList(imageList, ScaleTypes.FIT)
//    }
}

//    private fun getLiveNews() {
//
//        val livenews = liveservice.liveinstance.getlivelist()
//        livenews.enqueue(object : Callback<ListMatch> {
//            override fun onResponse(call: Call<ListMatch>, response: Response<ListMatch>) {
//
//                if (response.isSuccessful) {
//                    val live: ListMatch? = response.body()
//
//                    if (live != null && live.matchList.isNotEmpty()) {
//                        Log.d("success2", live.toString())
//                        adapter2 = NewsAdapter(mActivity!!, live.matchList)
//                        rec.adapter = adapter2
//                        adapter2.notifyDataSetChanged()
//                        rec.layoutManager = LinearLayoutManager(mActivity)
//                        rec.setHasFixedSize(true)
//
//
//                    } else {
//                        Log.d("live", "live data is null or empty")
//                        Toast.makeText(mActivity, "No live data found", Toast.LENGTH_LONG).show()
//                    }
//
//                }
//            }
//
//            override fun onFailure(call: Call<ListMatch>, t: Throwable) {
//
//                Log.d("Live Error", "Error in fetching live news", t)
//                Toast.makeText(mActivity, "Error in fetching live news", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
//}


//        fun sliderImage2() {
//
//            val imageList = ArrayList<SlideModel>()
//            imageList.add(SlideModel(R.drawable.ball))
//            imageList.add(SlideModel(R.drawable.bat))
//            imageList.add(SlideModel(R.drawable.cricket))
//            imageList.add(SlideModel(R.drawable.wicket))
//
//            imageSlider.setImageList(imageList, ScaleTypes.FIT)
//        }


