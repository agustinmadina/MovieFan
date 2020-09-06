package com.madina.sampleapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madina.sampleapp.R
import com.madina.sampleapp.domain.model.Movie
import com.madina.sampleapp.ui.utils.RuntimeScoped
import com.madina.sampleapp.ui.utils.loadImageFromOtherRepo
import kotlinx.android.synthetic.main.item_layout.view.*
import javax.inject.Inject

@RuntimeScoped
class MainAdapter @Inject constructor(private val listener: MovieListener) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    interface MovieListener {
        fun onMovieClick(movie: Movie)
    }

    private val items = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DataViewHolder(inflater.inflate(R.layout.item_layout, parent, false), listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(items[position])

    fun addData(users: List<Movie>) {
        this.items.apply {
            clear()
            addAll(users)
            notifyDataSetChanged()
        }
    }

    fun clearItems() {
        items.clear()
        notifyDataSetChanged()
    }

    class DataViewHolder(itemView: View, private val listener: MovieListener) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            itemView.textViewUserName.text = movie.title
            itemView.textViewUserEmail.text = movie.releaseDate
            movie.posterPath?.let { itemView.imageViewAvatar.loadImageFromOtherRepo(movie.posterPath) }
            itemView.setOnClickListener { listener.onMovieClick(movie) }
        }
    }

}