package com.example.sportsnews.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sportsnews.NewsExplaination
import com.example.sportsnews.R
import com.example.sportsnews.models.Matchlist

class latest_newsAdapter(val context: Context, val listoflatestnews:List<Matchlist.SportsNews.LatestNew>) : RecyclerView.Adapter<latest_newsAdapter.latestNewsViewModal>() {

    class latestNewsViewModal(val itemview : View) : RecyclerView.ViewHolder(itemview) {

        val Img_latestNews : ImageView = itemview.findViewById(R.id.Img_laestnews)
        val Txt_resourcelatestnews : TextView = itemview.findViewById(R.id.Txt_resourcelatestnews)
        val Txt_descriptionlatestnews : TextView = itemview.findViewById(R.id.Txt_descriptionlatestnews)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): latestNewsViewModal {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.latestnews_list, parent , false)

        return latestNewsViewModal(view)
    }

    override fun getItemCount(): Int {

        return listoflatestnews.size
    }

    override fun onBindViewHolder(holder: latestNewsViewModal, position: Int) {

            val latestnewslist = listoflatestnews[position]

            Glide.with(context).load(listoflatestnews[position].newsImage).placeholder(R.drawable.error).into(holder.Img_latestNews)
            holder.Txt_resourcelatestnews.text = latestnewslist.newsLink
            holder.Txt_descriptionlatestnews.text = latestnewslist.newsTitle
            holder.itemview.setOnClickListener {

                val intent = Intent(context , NewsExplaination::class.java)
                intent.putExtra("newsId", latestnewslist.newsId.toString())
                context.startActivity(intent)

            }
    }
}