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
import com.example.sportsnews.Fragments.Live


class NewsAdapter(val context : Context, var listofnews: ArrayList<News>):RecyclerView.Adapter<NewsAdapter.viewholder>() {

    class viewholder(itemView : View) : RecyclerView.ViewHolder(itemView){


        var live : TextView = itemView.findViewById(R.id.live)
        var matchdetails : TextView = itemView.findViewById(R.id.matchdetails)
        var bellimage : ImageView = itemView.findViewById(R.id.bellImage)
        var country_Ind : ImageView = itemView.findViewById(R.id.country_Ind)
        var Ind_text : TextView = itemView.findViewById(R.id.Ind_text)
        var timings : TextView = itemView.findViewById(R.id.timing)
        var Usa_text : TextView = itemView.findViewById(R.id.USA_text)
        var country_Usa : ImageView = itemView.findViewById(R.id.country_USA)
        var table : TextView = itemView.findViewById(R.id.table)
        val schedule : TextView = itemView.findViewById(R.id.schedule)

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlist,parent,false)
        return viewholder(view)
    }

    override fun getItemCount(): Int {

        return listofnews.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {

        holder.live.text = listofnews[position].live
        holder.matchdetails.text = listofnews[position].matchdetails
        listofnews[position].bellimage.let { holder.bellimage.setImageResource(it)}
        listofnews[position].country_ind.let { holder.country_Ind.setImageResource(it) }
        holder.Ind_text.text = listofnews[position].Ind_text
        holder.timings.text = listofnews[position].timings
        holder.Usa_text.text = listofnews[position].Usa_text
        listofnews[position].country_usa.let { holder.country_Usa.setImageResource(it) }
        holder.table.text = listofnews[position].table
        holder.schedule.text = listofnews[position].schedule

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