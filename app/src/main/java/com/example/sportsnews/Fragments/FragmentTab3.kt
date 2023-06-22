package com.example.sportsnews.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsnews.NewsInfo_Adapter
import com.example.sportsnews.Newsdata
import com.example.sportsnews.Newsservice
import com.example.sportsnews.R
import com.example.sportsnews.newsdetails


class FragmentTab3 : Fragment() {

      lateinit var rec : RecyclerView
      lateinit var adapter : NewsInfo_Adapter
      var newslist = ArrayList<newsdetails>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view =  inflater.inflate(R.layout.fragment_tab3, container, false)

        rec = view.findViewById(R.id.recycler_newlist)
        rec.layoutManager = LinearLayoutManager(activity as Context)
        rec.setHasFixedSize(true)

        getnews()

        return view

    }

    private fun getnews() {

        val News = Newsservice.newsInstance.getheadlines("in",1,"sports")
        News.enqueue(object : retrofit2.Callback<Newsdata> {
            override fun onResponse(call: retrofit2.Call<Newsdata>, response: retrofit2.Response<Newsdata>) {
                val newsData: Newsdata? = response.body()

                if (newsData != null && newsData.articles.isNotEmpty()){
                    Log.d("success", newsData.toString())
                    adapter = NewsInfo_Adapter(activity as Context , newsData.articles)
                    rec.adapter = adapter
                    adapter.notifyDataSetChanged()
                    rec.layoutManager = LinearLayoutManager(activity as Context)
                    rec.setHasFixedSize(true)

                } else {
                    Log.d("News", "News data is null or empty")
                    Toast.makeText(activity as Context, "No news found", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: retrofit2.Call<Newsdata>, t: Throwable) {

                Log.d("News","Error in fetching news", t)

                Toast.makeText(activity as Context , "Error incoming", Toast.LENGTH_LONG).show()

            }
        })


    }


}