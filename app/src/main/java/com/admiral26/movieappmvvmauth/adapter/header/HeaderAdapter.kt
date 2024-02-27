package com.admiral26.movieappmvvmauth.adapter.header

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.admiral26.movieappmvvmauth.data.model.home.header.ResultHead
import com.admiral26.movieappmvvmauth.databinding.ItemHeaderBinding
import com.bumptech.glide.Glide

class HeaderAdapter : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    private val data = ArrayList<ResultHead>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<ResultHead>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }


    inner class HeaderViewHolder(private val binding: ItemHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: ResultHead) {
            binding.titleFilm.text = data.originalTitle
            binding.ratingHed.text = data.voteAverage.toString()
            Glide.with(binding.cardView.context)
                .load("https://image.tmdb.org/t/p/original/${data.posterPath}")
                .into(binding.cardView)
        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HeaderAdapter.HeaderViewHolder {
        return HeaderViewHolder(
            ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount() = data.size
}