package com.example.sportsnews.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sportsnews.NewsExplaination
import com.example.sportsnews.R
import com.example.sportsnews.models.NewsTrendingHighlights

class Report_Adapter(val context : Context , val reportlist : List<NewsTrendingHighlights.NewsDetails.TrendingNew>) : RecyclerView.Adapter<Report_Adapter.Report_viewholder>() {


    class Report_viewholder (itemview : View):RecyclerView.ViewHolder(itemview) {


        val Img_report  : ImageView = itemview.findViewById(R.id.Img_report)
        val Txt_views : TextView = itemview.findViewById(R.id.Txt_views)
        val Txt_report_title : TextView = itemview.findViewById(R.id.Txt_report_title)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Report_viewholder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.report_list, parent , false)

        return  Report_viewholder(view)
    }

    override fun getItemCount(): Int {

        return reportlist.size
    }

    override fun onBindViewHolder(holder: Report_viewholder, position: Int) {

        val report = reportlist[position]

      holder.Txt_views.text = report.newsViews
      holder.Txt_report_title.text = report.newsDescription

     Glide.with(context).load(report.newsImage).placeholder(R.drawable.error).into(holder.Img_report)


        holder.itemView.setOnClickListener {

        val intent = Intent(context , NewsExplaination::class.java)
        intent.putExtra("newsId", report.newsId.toString())
        intent.putExtra("news_type", "trending")
        context.startActivity(intent)

        }


    }


}