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
import com.example.sportsnews.models.NewsTrendingHighlights

class Highlights_Adapter (val context : Context , val highlightslist : List<NewsTrendingHighlights.NewsDetails.Highlight>) : RecyclerView.Adapter<Highlights_Adapter.highlights_viewmodal>() {

    class highlights_viewmodal (itemView : View) : RecyclerView.ViewHolder(itemView) {

        val Img_highlights : ImageView = itemView.findViewById(R.id.Img_highlights)
        val Txt_highlights_resource : TextView = itemView.findViewById(R.id.Txt_highlights_resource)
        val Txt_hightlights_date : TextView = itemView.findViewById(R.id.Txt_highlights_date)
        val Txt_highlights_title : TextView = itemView.findViewById(R.id.Txt_highlights_title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): highlights_viewmodal {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_highlights, parent , false)

        return highlights_viewmodal(view)
    }

    override fun getItemCount(): Int {

        return highlightslist.size
    }

    override fun onBindViewHolder(holder: highlights_viewmodal, position: Int) {

        val highlights = highlightslist[position]

        holder.Txt_highlights_resource.text = highlights.newSource
        holder.Txt_hightlights_date.text =highlights.newsDate
        holder.Txt_highlights_title.text = highlights.newsTitle


        Glide.with(context).load(highlights.newsImage).placeholder(R.drawable.error).into(holder.Img_highlights)

          holder.itemView.setOnClickListener{

           val intent = Intent(context , NewsExplaination::class.java)
           intent.putExtra("newsId", highlights.newsId.toString())
           intent.putExtra("news_type", "highlights")
           context.startActivity(intent)
       }
    }


    interface OnItemClickListener {
        fun onItemClick(newsId: String)
    }
}