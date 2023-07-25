package com.example.sportsnews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsnews.Fragments.DetailNewsFragment


class NewsAdapter(val context : Context, val listofnews: ArrayList<ListMatch>):RecyclerView.Adapter<NewsAdapter.viewholder>() {

    class viewholder(itemView : View) : RecyclerView.ViewHolder(itemView){


        var league : TextView = itemView.findViewById(R.id.league)
        var frontteam_name : TextView = itemView.findViewById(R.id.frontteaname)
        var oppteam_name : TextView = itemView.findViewById(R.id.opponentteamname)
        var fronteamlogo : ImageView = itemView.findViewById(R.id.frontteamlogo)
        var time : TextView = itemView.findViewById(R.id.time)
        var date : TextView = itemView.findViewById(R.id.date)
        var oppteamlogo : ImageView = itemView.findViewById(R.id.opponentteamlogo)



    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlist,parent,false)
        return viewholder(view)
    }

    override fun getItemCount(): Int {

        return minOf(listofnews.size, 2)

//        return  listofnews.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {

        val livelist = listofnews[position]

        holder.league.text = listofnews[position].league


        holder.frontteam_name.text = listofnews[position].frontteam_countryName

        holder.oppteam_name.text = listofnews[position].opponentteam_countryName



//            Glide.with(context).load(livelist.frontTeamLogo).into(holder.fronteamlogo)

        listofnews[position].frontteam_logo.let { holder.fronteamlogo.setImageResource(it)}


        holder.time.text = listofnews[position].time
        holder.date.text = listofnews[position].date



//            Glide.with(context).load(livelist.oppTeamLogo).into(holder.oppteamlogo)

        listofnews[position].opponentteam_logo.let { holder.oppteamlogo.setImageResource(it)}



         holder.itemView.setOnClickListener {

/**          val fragmentManager = (holder.itemView.context as AppCompatActivity).supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction() */


             val fragmentmanager = (holder.itemView.context as AppCompatActivity).supportFragmentManager
             val transaction = fragmentmanager.beginTransaction()
             transaction.replace(R.id.Framelayout , DetailNewsFragment())
//             transaction.commit()

        /**   if (position == 0) {
                 val fragmentA = live_Fragment()
                 fragmentTransaction.replace(R.id.Framelayout, fragmentA)
             } else if (position == 1) {
                 val fragmentB = NewsDetailFragment()
                 fragmentTransaction.replace(R.id.Framelayout, fragmentB)
             } */

             transaction.addToBackStack("NewsDetailFragment")
             transaction.commit()

         }
    }

}