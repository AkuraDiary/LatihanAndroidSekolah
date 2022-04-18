package com.smktelkommlg.movieproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.movie_adapter, parent, false)
        return ViewHolder(parent)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_poster : ImageView = itemView.findViewById(R.id.img_poster)
        val title_view : TextView = itemView.findViewById(R.id.title_view)
        val release_view : TextView = itemView.findViewById(R.id.realesed_view)
        val genre_view : TextView = itemView.findViewById(R.id.genre_view)
    }
}