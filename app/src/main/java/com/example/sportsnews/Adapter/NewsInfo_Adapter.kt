package com.example.sportsnews.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sportsnews.NewsExplaination
import com.example.sportsnews.R
import com.example.sportsnews.models.NewInfo


class NewsInfo_Adapter (val context : Context , val newsinfolist : List<NewInfo.New>): RecyclerView.Adapter<NewsInfo_Adapter.ViewHolder>()  {

    class ViewHolder (itemview : View):RecyclerView.ViewHolder(itemview){

        val Txt_source : TextView = itemview.findViewById(R.id.Txt_source)
        val Txt_des : TextView = itemview.findViewById(R.id.Txt_des)
        val Img_news : ImageView = itemview.findViewById(R.id.Img_news)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.newslist,parent,false)

        return ViewHolder(view)

    }

    override fun getItemCount(): Int {

        return newsinfolist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val newslist = newsinfolist[position]

        holder.Txt_source.text = newslist.newsTitle
        holder.Txt_des.text = newslist.newsDescription
       Glide.with(context).load(newsinfolist[position].newsImage).into(holder.Img_news)


        holder.itemView.setOnClickListener {

            val intent = Intent(context , NewsExplaination::class.java)
            ContextCompat.startActivity(context, intent, null)

        }


    }
}