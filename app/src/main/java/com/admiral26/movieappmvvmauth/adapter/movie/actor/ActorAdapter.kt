package com.admiral26.movieappmvvmauth.adapter.movie.actor

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.admiral26.movieappmvvmauth.R
import com.admiral26.movieappmvvmauth.data.model.detail.credit.Cast
import com.admiral26.movieappmvvmauth.databinding.ActorViewLayoutBinding
import com.bumptech.glide.Glide

class ActorAdapter : RecyclerView.Adapter<ActorAdapter.ActorViewHolder>() {
    private val data = ArrayList<Cast>()
    var onClicked: ((actorId: Int) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Cast>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ActorViewHolder(private val binding: ActorViewLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: Cast) {
            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/original/${data.profilePath}")
                .placeholder(R.drawable.empty_image)
                .error(R.drawable.empty_image)
                .into(binding.ivActor)

            binding.tvActorValue.text = data.name

            itemView.setOnClickListener {
                onClicked?.invoke(data.id)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ActorAdapter.ActorViewHolder {
        return ActorViewHolder(
            ActorViewLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ActorAdapter.ActorViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount() = data.size
}