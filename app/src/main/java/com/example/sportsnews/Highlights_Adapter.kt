package com.example.sportsnews

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class Highlights_Adapter (val context : Context , val highlightslist : ArrayList<highlights_data>) : RecyclerView.Adapter<Highlights_Adapter.highlights_viewmodal>() {

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

        holder.Txt_highlights_resource.text = highlightslist[position].Txt_highlights_resource
        holder.Txt_hightlights_date.text = highlightslist[position].Txt_hightlightsdate
        holder.Txt_highlights_title.text = highlightslist[position].Txt_highlights_title

        highlightslist[position].Img_highlights.let { holder.Img_highlights.setImageResource(it) }

       holder.itemView.setOnClickListener{

//           val fragmentmanager = (holder.itemView.context as AppCompatActivity).supportFragmentManager
//           val transaction = fragmentmanager.beginTransaction()
//           transaction.replace(R.id.Framelayout , News_Explaination ())
//
//           transaction.addToBackStack("NewsDetailFragment")
//           transaction.commit()


            val i = Intent(context , NewsExplaination::class.java)

            context.startActivity(i)
       }
    }
}