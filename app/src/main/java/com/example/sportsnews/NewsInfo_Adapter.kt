package com.example.sportsnews

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sportsnews.models.newsdetails


class NewsInfo_Adapter (val context : Context , val newsinfolist : ArrayList<newsdetails>): RecyclerView.Adapter<NewsInfo_Adapter.ViewHolder>()  {

    class ViewHolder (itemview : View):RecyclerView.ViewHolder(itemview){

        val Txt_title : TextView = itemview.findViewById(R.id.Txt_title)
        val Txt_des : TextView = itemview.findViewById(R.id.Txt_des)
        val Img_news : ImageView = itemview.findViewById(R.id.Img_news)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.newslist ,parent,false)

        return ViewHolder(view)

    }

    override fun getItemCount(): Int {

        return newsinfolist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val newslist = newsinfolist[position]

        holder.Txt_title.text = newsinfolist[position].title
        holder.Txt_des.text = newsinfolist[position].description
        Glide.with(context).load(newslist.urlToImage).into(holder.Img_news)
        holder.itemView.setOnClickListener {

            val builder =  CustomTabsIntent.Builder()
            val customTabsIntent = builder.build()
            customTabsIntent.launchUrl(context , Uri.parse(newslist.url))

        }


    }
}