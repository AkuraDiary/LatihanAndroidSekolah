package com.smktelkommlg.movieproject

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife
import com.bumptech.glide.Glide


class MovieAdapter(private val listMovies : ArrayList<SearchItem>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.movie_adapter, parent, false)
        return ViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title_view.text = listMovies[position].title
        holder.genre_view.text = listMovies[position].type
        holder.release_view.text = listMovies[position].year

        Glide.with(holder.itemView.context)
            .load(listMovies[position].poster)
            .into(holder.img_poster)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listMovies: ArrayList<SearchItem>) {
        this.listMovies.clear()
        this.listMovies.addAll(listMovies)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val img_poster : ImageView = itemView.findViewById(R.id.img_poster)
        val title_view : TextView = itemView.findViewById(R.id.title_view)
        val release_view : TextView = itemView.findViewById(R.id.realesed_view)
        val genre_view : TextView = itemView.findViewById(R.id.genre_view)
    }
}