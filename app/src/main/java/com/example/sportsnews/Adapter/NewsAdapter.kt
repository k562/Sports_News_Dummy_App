package com.example.sportsnews.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sportsnews.Fragments.DetailNewsFragment
import com.example.sportsnews.R
import com.example.sportsnews.models.Matchlist


class NewsAdapter(val context: Context, val matchlist:List<Matchlist.SportsNews.MatchesData>):RecyclerView.Adapter<NewsAdapter.viewholder>() {

    class viewholder(itemView : View) : RecyclerView.ViewHolder(itemView){


        var league : TextView = itemView.findViewById(R.id.league)
        var frontteam_name : TextView = itemView.findViewById(R.id.frontteaname)
        var oppteam_name : TextView = itemView.findViewById(R.id.opponentteamname)
        var fronteamlogo : ImageView = itemView.findViewById(R.id.frontteamlogo)
        var fronteamscore : TextView = itemView.findViewById(R.id.frontteamscore)
        var oppteamscore : TextView = itemView.findViewById(R.id.oppteamscore)
        var oppteamlogo : ImageView = itemView.findViewById(R.id.opponentteamlogo)

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlist,parent,false)
        return viewholder(view)
    }

    override fun getItemCount(): Int {

        return minOf(matchlist.size, 2)

//        return  listofnews.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {

        //val livelist = listofnews[position]

        val data=matchlist[position]
        holder.league.text = data.seriesName


        holder.frontteam_name.text = data.frontTeam.frontTeamName

        holder.oppteam_name.text = data.oppTeam.oppTeamName



         Glide.with(context).load(matchlist[position].frontTeam.frontTeamLogo).into(holder.fronteamlogo)

//        listofnews[position].frontteam_logo.let { holder.fronteamlogo.setImageResource(it)}


        holder.fronteamscore.text = data.frontTeam.frontTeamScore
        holder.oppteamscore.text = data.oppTeam.oppTeamScore


        Glide.with(context).load(matchlist[position].oppTeam.oppTeamLogo).placeholder(R.drawable.iconerror).into(holder.oppteamlogo)

//        listofnews[position].opponentteam_logo.let { holder.oppteamlogo.setImageResource(it)}



         holder.itemView.setOnClickListener {

             val fragmentmanager = (holder.itemView.context as AppCompatActivity).supportFragmentManager
             val transaction = fragmentmanager.beginTransaction()
             transaction.replace(R.id.Framelayout, DetailNewsFragment())

             transaction.addToBackStack("NewsDetailFragment")
             transaction.commit()

         }
    }

}