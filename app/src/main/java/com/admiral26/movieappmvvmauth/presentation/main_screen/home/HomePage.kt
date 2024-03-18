package com.admiral26.movieappmvvmauth.presentation.main_screen.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.MediatorLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.admiral26.movieappmvvmauth.R
import com.admiral26.movieappmvvmauth.adapter.multi.MultiAdapter
import com.admiral26.movieappmvvmauth.base.BaseFragment
import com.admiral26.movieappmvvmauth.data.model.home.footer.FootResponse
import com.admiral26.movieappmvvmauth.data.model.home.header.HeaderResponse
import com.admiral26.movieappmvvmauth.databinding.PageHomeBinding
import com.admiral26.movieappmvvmauth.presentation.main_screen.MainScreenDirections


class HomePage : BaseFragment(R.layout.page_home) {

    private val binding by viewBinding(PageHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels<HomeViewModelImp>()
    private val data = MediatorLiveData<Pair<HeaderResponse?, FootResponse?>>()
    private val adapter by lazy { MultiAdapter() }



    override fun onCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getHeader()
        viewModel.getFooter()
        setAdapter()
        observe()
        listenerActions()

    }


    private fun listenerActions() {
        adapter.onClick = {
            findNavController().navigate(MainScreenDirections.actionMainScreenToDetailScreen(it))
        }
    }


    private fun setAdapter() {
        binding.multiRvList.adapter = adapter
        binding.multiRvList.layoutManager = LinearLayoutManager(context)
        binding.multiRvList.setHasFixedSize(true)
    }


    private fun observe() {

        data.addSource(viewModel.headerLD) {
            data.value = Pair(it, data.value?.second)
        }

        data.addSource(viewModel.footerLD) {
            data.value = Pair(data.value?.first, it)
        }



        data.observe(viewLifecycleOwner) {

            val data1 = it.first
            val data2 = it.second
            Log.d("data11", "observe: ${data1}\n${data2}")

            if (data1 != null && data2 != null) {
                binding.progressHome.visibility = View.GONE
                adapter.addData(data1)
                Log.d("data1", "observe: $data1")
                adapter.addData(data2)
            }
        }
    }
}