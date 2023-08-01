package com.example.sportsnews.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import com.example.sportsnews.R
import com.example.sportsnews.models.UpcomingList

class UpcomingAdapter (var context : Context , var upcominglist : List<UpcomingList.UpcomingMatche>):RecyclerView.Adapter<UpcomingAdapter.upcomingViewHolder> () {


    class upcomingViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        val status : TextView = itemView.findViewById(R.id.Txt_matchstatus)
        val img1 : ImageView = itemView.findViewById(R.id.Img1)
        val textview1 : TextView = itemView.findViewById(R.id.textView1)
        val img2 : ImageView = itemView.findViewById(R.id.Img2)
        val textview2 : TextView = itemView.findViewById(R.id.textView2)
        val today : TextView = itemView.findViewById(R.id.today)
        val time : TextView = itemView.findViewById(R.id.time)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): upcomingViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.upcominglist, parent , false)

        return upcomingViewHolder(view)
    }

    override fun getItemCount(): Int {

        return upcominglist.size
    }

    override fun onBindViewHolder(holder: upcomingViewHolder, position: Int) {

        val upcomingData = upcominglist[position]

        holder.status.text = upcomingData.matchName

        Glide.with(context).load(upcominglist[position].frontTeam.frontTeamLogo).placeholder(R.drawable.iconerror).into(holder.img1)
        holder.textview1.text = upcomingData.frontTeam.frontTeamName

        Glide.with(context).load(upcominglist[position].oppTeam.oppTeamLogo).placeholder(R.drawable.iconerror).into(holder.img2)
        holder.textview2.text = upcomingData.oppTeam.oppTeamName


        holder.today.text = upcomingData.matchDate
        holder.time.text = upcomingData.matchTime


    }
}