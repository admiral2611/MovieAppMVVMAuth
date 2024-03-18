package com.admiral26.movieappmvvmauth.adapter.movie.actor

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.admiral26.movieappmvvmauth.R
import com.admiral26.movieappmvvmauth.data.model.detail.actor.image.Profile
import com.admiral26.movieappmvvmauth.databinding.ItemActorBinding
import com.bumptech.glide.Glide

class ActorImageAdapter : RecyclerView.Adapter<ActorImageAdapter.ActorViewHolder>() {
    private val data = ArrayList<Profile>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Profile>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ActorViewHolder(private val binding: ItemActorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data:Profile) {
            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/original/${data.filePath}")
                .placeholder(R.drawable.empty_image)
                .error(R.drawable.empty_image)
                .into(binding.actorImage)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ActorImageAdapter.ActorViewHolder {
        return ActorViewHolder(
            ItemActorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ActorImageAdapter.ActorViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount() = data.size
}