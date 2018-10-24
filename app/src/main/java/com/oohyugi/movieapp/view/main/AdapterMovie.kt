package com.oohyugi.movieapp.view.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.google.gson.Gson
import com.oohyugi.movieapp.R
import com.oohyugi.movieapp.model.SearchItemMdl
import com.oohyugi.movieapp.view.detail.DetailActivity
import com.squareup.picasso.Picasso

/**
 * Created by oohyugi on 09/10/18.
 * github: https://github.com/oohyugi
 */
class AdapterMovie(private val context: Context, private val list: List<SearchItemMdl>) : RecyclerView.Adapter<AdapterMovie.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
        var tvDate = itemView.findViewById<TextView>(R.id.tv_date)
        var img = itemView.findViewById<ImageView>(R.id.img_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val view = inflater.inflate(R.layout.items_list_movie, parent, false)


        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]


        holder.tvTitle.text=item.title
        holder.tvDate.text = item.year
        Picasso.with(context).load(item.poster).resize(100,100).into(holder.img)




        holder.itemView.setOnClickListener{
           DetailActivity.startThisActivity(context,item.imdbID)


        }
    }




    override fun getItemCount(): Int {
        return list.size
    }

    companion object {

        private val TAG = AdapterMovie::class.java.simpleName
    }


}