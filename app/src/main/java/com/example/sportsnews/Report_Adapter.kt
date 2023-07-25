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
import com.example.sportsnews.Fragments.DetailNewsFragment

class Report_Adapter(val context : Context , val reportlist : ArrayList<Report_Data_class>) : RecyclerView.Adapter<Report_Adapter.Report_viewholder>() {


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

      holder.Txt_views.text = reportlist[position].Txt_views
      holder.Txt_report_title.text = reportlist[position].Txt_report_title

       // holder.Img_report.setImageResource(reportlist[position].Img_report)

        reportlist[position].Img_report.let { holder.Img_report.setImageResource(it) }


        holder.itemView.setOnClickListener {


//            val fragmentmanager = (holder.itemView.context as AppCompatActivity).supportFragmentManager
//            val transaction = fragmentmanager.beginTransaction()
//            transaction.replace(R.id.Framelayout , News_Explaination())
//
//            transaction.addToBackStack("NewsDetailFragment")
//            transaction.commit()


            val intent = Intent(context , NewsExplaination::class.java)
            startActivity(context , intent , null)
        }


    }


}