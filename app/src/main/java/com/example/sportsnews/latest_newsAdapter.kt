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
import com.example.sportsnews.Fragments.FragmentTab3
import java.util.ArrayList

class latest_newsAdapter(val context: Context, val latest_news_list: ArrayList<latest_news_data>) : RecyclerView.Adapter<latest_newsAdapter.latestNewsViewModal>() {

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

        return latest_news_list.size
    }

    override fun onBindViewHolder(holder: latestNewsViewModal, position: Int) {

            val latestnewslist = latest_news_list[position]

            holder.Img_latestNews.setImageResource(latestnewslist.Img_latestNews)
            holder.Txt_resourcelatestnews.text = latestnewslist.Txt_resourcelatestnews
            holder.Txt_descriptionlatestnews.text = latestnewslist.Txt_descriptionlatestnews

            holder.itemview.setOnClickListener {

//                val fragmentmanager = (holder.itemview.context as AppCompatActivity).supportFragmentManager
//                val transaction = fragmentmanager.beginTransaction()
//                transaction.replace(R.id.Framelayout , FragmentTab3())
//
//                transaction.addToBackStack("NewsDetailFragment")
//                transaction.commit()

                val title = latest_news_list[position].Txt_resourcelatestnews
                val intent = Intent(context, NewsExplaination::class.java)
                intent.putExtra("title", title)
                context.startActivity(intent)




            }
    }
}