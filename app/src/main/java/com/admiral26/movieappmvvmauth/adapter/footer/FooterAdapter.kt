package com.admiral26.movieappmvvmauth.adapter.footer

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.admiral26.movieappmvvmauth.data.model.home.footer.FootResponse
import com.admiral26.movieappmvvmauth.data.model.home.footer.ResultFoot
import com.admiral26.movieappmvvmauth.databinding.ItemFooterBinding
import com.admiral26.movieappmvvmauth.util.getGenre
import com.bumptech.glide.Glide


class FooterAdapter : RecyclerView.Adapter<FooterAdapter.FootViewHolder>() {

    var onClick: ((id: Int) -> Unit)? = null
    private val data = ArrayList<ResultFoot>()

    fun setDataFoot(data: List<ResultFoot>) {
        this.data.clear()
        this.data.addAll(data.shuffled())
        notifyDataSetChanged()
    }

    inner class FootViewHolder(private val binding: ItemFooterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: ResultFoot) {
            binding.rating.text = String.format("%s/10 IMDb", data.voteAverage)
            binding.title.text = data.originalTitle
            binding.textData.text = data.releaseDate
            Log.d("category1", "bindData: ${data.genreIds}")

            if (data.genreIds.size >= 3) {
                binding.category1.text = getGenre(data.genreIds[0])
                binding.category2.text = getGenre(data.genreIds[1])
                binding.category3.text = getGenre(data.genreIds[2])
            } else {
                binding.category1.text = getGenre(data.genreIds[0])
                binding.category2.visibility = View.GONE
                binding.category3.visibility = View.GONE
            }
            //binding.category3.text = getGenre(data.genreIds[2])
            Glide.with(binding.shapeableImageView.context)
                .load("https://image.tmdb.org/t/p/original${data.posterPath}")
                .into(binding.shapeableImageView)


            itemView.setOnClickListener {
                onClick?.invoke(data.id)
            }
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

    override fun getItemCount() = data.size
}