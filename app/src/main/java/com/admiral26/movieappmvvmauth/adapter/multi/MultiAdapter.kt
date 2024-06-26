package com.admiral26.movieappmvvmauth.adapter.multi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.admiral26.movieappmvvmauth.adapter.footer.FooterAdapter
import com.admiral26.movieappmvvmauth.adapter.header.HeaderAdapter
import com.admiral26.movieappmvvmauth.data.model.BaseModel
import com.admiral26.movieappmvvmauth.data.model.home.footer.FootResponse
import com.admiral26.movieappmvvmauth.data.model.home.header.HeaderResponse
import com.admiral26.movieappmvvmauth.databinding.ItemBannerHeaderBinding
import com.admiral26.movieappmvvmauth.databinding.ItemFooterParentBinding
import com.admiral26.movieappmvvmauth.util.view_pager_transformation.OverlapSliderTransformer


class MultiAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var onClick: ((id: Int) -> Unit)? = null
    var footerSeeClick: (() -> Unit)? = null


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
        notifyItemInserted(this.data.size)
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].getType()
    }

    inner class BannerViewHolder(private val binding: ItemBannerHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val adapter = HeaderAdapter()

        fun bindDataToHeader(data: HeaderResponse) {
            binding.viewPagerHeader.adapter = adapter
            binding.viewPagerHeader.offscreenPageLimit = 3
            binding.viewPagerHeader.setPageTransformer(OverlapSliderTransformer(ViewPager2.ORIENTATION_HORIZONTAL))
            adapter.setData(data = data.resultHeads)

            adapter.onClick = {
                onClick?.invoke(it)
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

            adapter.onClick = {
                onClick?.invoke(it)
            }
            binding.seeMore.setOnClickListener {
                footerSeeClick?.invoke()
            }
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

    override fun getItemCount() = data.size

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