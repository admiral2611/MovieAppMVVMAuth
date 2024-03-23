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
import okhttp3.internal.wait


class HomePage : BaseFragment(R.layout.page_home) {

    private val binding by viewBinding(PageHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels<HomeViewModelImp>()
    private val adapter by lazy { MultiAdapter() }
    val data = MediatorLiveData<Pair<HeaderResponse?, FootResponse?>>()
    //private var isFirstDataAdded = false


    override fun onCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        observe()
        listenerActions()
        viewModel.getHeader()
        viewModel.getFooter()
    }




    private fun listenerActions() {
        adapter.onClick = {
            findNavController().navigate(MainScreenDirections.actionMainScreenToDetailScreen(it))

        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("aa11", "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("aa11", "onStop: ")
    }

    override fun onResume() {
        super.onResume()

        Log.d("aa11", "onResume: ")
    }

    private fun setAdapter() {
        binding.multiRvList.adapter = adapter
        binding.multiRvList.layoutManager = LinearLayoutManager(context)
        binding.multiRvList.setHasFixedSize(true)
    }



    private fun observe() {
        var isFirstDataAdded = false
        data.addSource(viewModel.headerLD) {data1 ->

                data.value = Pair(data1, data.value?.second)

        }
        data.addSource(viewModel.footerLD) {data2 ->

                data.value = Pair(data.value?.first, data2)
        }

        data.observe(viewLifecycleOwner) {
            val data1 = it.first
            val data2 = it.second
            if (data1 != null && data2 != null) {
                binding.progressHome.visibility = View.GONE
                adapter.addData(data1)
                adapter.addData(data2)
            }
        }
    }
}