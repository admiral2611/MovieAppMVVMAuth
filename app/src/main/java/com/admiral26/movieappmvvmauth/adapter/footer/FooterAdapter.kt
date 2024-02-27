package com.admiral26.movieappmvvmauth.adapter.footer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.admiral26.movieappmvvmauth.data.model.home.footer.FootResponse
import com.admiral26.movieappmvvmauth.data.model.home.footer.ResultFoot
import com.admiral26.movieappmvvmauth.databinding.ItemFooterBinding
import com.bumptech.glide.Glide


class FooterAdapter : RecyclerView.Adapter<FooterAdapter.FootViewHolder>() {

    private val data = ArrayList<ResultFoot>()

    fun setDataFoot(data: List<ResultFoot>) {
        this.data.clear()
        this.data.addAll(data.shuffled())
        notifyDataSetChanged()
    }

    inner class FootViewHolder(private val binding: ItemFooterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: ResultFoot) {
            binding.rating.text = data.voteAverage.toString()
            binding.title.text = data.originalTitle
            binding.textData.text = data.releaseDate
            Glide.with(binding.shapeableImageView.context)
                .load("https://image.tmdb.org/t/p/original${data.posterPath}")
                .into(binding.shapeableImageView)


        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FootViewHolder {

        return FootViewHolder(
            ItemFooterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FootViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount()=data.size
}