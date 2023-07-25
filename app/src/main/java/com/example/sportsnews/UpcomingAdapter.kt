package com.example.sportsnews

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class UpcomingAdapter (var context : Context , var upcominglist : ArrayList<upcomingData>):RecyclerView.Adapter<UpcomingAdapter.upcomingViewHolder> () {


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

        val view = LayoutInflater.from(parent.context).inflate(R.layout.upcominglist , parent , false)

        return upcomingViewHolder(view)
    }

    override fun getItemCount(): Int {

        return upcominglist.size
    }

    override fun onBindViewHolder(holder: upcomingViewHolder, position: Int) {

        val upcomingData = upcominglist[position]

        holder.status.text = upcominglist[position].status
//      holder.img1.setImageResource(upcominglist[position].img1)
        upcominglist[position].img1.let { holder.img1.setImageResource(it) }
        holder.textview1.text = upcominglist[position].textview1



        upcominglist[position].img2.let { holder.img2.setImageResource(it) }
        holder.textview2.text = upcominglist[position].textview2
        holder.today.text = upcominglist[position].today
        holder.time.text = upcominglist[position].time






    }
}