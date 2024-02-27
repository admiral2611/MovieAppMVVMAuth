package com.admiral26.movieappmvvmauth.adapter.multi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.admiral26.movieappmvvmauth.adapter.footer.FooterAdapter
import com.admiral26.movieappmvvmauth.adapter.header.HeaderAdapter
import com.admiral26.movieappmvvmauth.data.model.BaseModel
import com.admiral26.movieappmvvmauth.data.model.home.footer.FootResponse
import com.admiral26.movieappmvvmauth.data.model.home.header.HeaderResponse
import com.admiral26.movieappmvvmauth.databinding.ItemBannerHeaderBinding
import com.admiral26.movieappmvvmauth.databinding.ItemFooterParentBinding


class MultiAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var onClick: ((title: String) -> Unit)? = null


    private val data = ArrayList<BaseModel>()

    fun setData(multiData: ArrayList<BaseModel>) {
        this.data.clear()
        data.sortBy { it.getType() }
        this.data.addAll(multiData)
        notifyDataSetChanged()
    }

    fun addData(data: BaseModel) {
        this.data.add(data)
        this.data.sortBy { it.getType() }
        notifyItemChanged(this.data.size)
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].getType()
    }

    inner class BannerViewHolder(private val binding: ItemBannerHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val adapter = HeaderAdapter()

        fun bindDataToHeader(data: HeaderResponse) {
            binding.viewPagerHeader.adapter = adapter
            adapter.setData(data = data.resultHeads)

            itemView.setOnClickListener{
                onClick?.invoke(data.toString())
            }
        }
    }

    inner class FootViewHolder(private val binding: ItemFooterParentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val adapter = FooterAdapter()
        fun bindDataToFoot(data: FootResponse) {
            binding.rvList.adapter = adapter
            binding.rvList.layoutManager = LinearLayoutManager(binding.root.context)
            adapter.setDataFoot(data = data.resultFoots)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            BaseModel.TOP_HEAD_LINE -> {
                BannerViewHolder(
                    ItemBannerHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                FootViewHolder(
                    ItemFooterParentBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
        }
    }

    override fun getItemCount()=data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            BaseModel.TOP_HEAD_LINE -> {
                (holder as BannerViewHolder).bindDataToHeader(data = data[position] as HeaderResponse)
            }

            BaseModel.FOOT_LINE -> {
                (holder as FootViewHolder).bindDataToFoot(data = data[position] as FootResponse)
            }
        }
    }
}