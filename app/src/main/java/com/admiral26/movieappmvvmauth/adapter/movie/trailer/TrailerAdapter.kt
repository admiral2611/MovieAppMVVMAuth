package com.admiral26.movieappmvvmauth.adapter.movie.trailer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.admiral26.movieappmvvmauth.data.model.detail.trailer.ResultTrailer
import com.admiral26.movieappmvvmauth.databinding.ItemTrailerBinding

class TrailerAdapter : RecyclerView.Adapter<TrailerAdapter.ViewHolder>() {

    private val data = ArrayList<ResultTrailer>()
    var onClickTrailer: ((url: String) -> Unit)? = null

    fun setData(data: List<ResultTrailer>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemTrailerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: ResultTrailer) {
            itemView.setOnClickListener {
                onClickTrailer?.invoke(data.key)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTrailerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(data[position])
    }


}
