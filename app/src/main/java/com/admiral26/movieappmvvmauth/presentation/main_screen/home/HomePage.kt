package com.admiral26.movieappmvvmauth.presentation.main_screen.home

import android.os.Bundle
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
    private val adapter by lazy { MultiAdapter() }
    val data = MediatorLiveData<Pair<HeaderResponse?, FootResponse?>>()
    private var header = false
    private var foot = false
    private var firstSource = false
    private val page = 1

    override fun onCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        observe()
        listenerActions()
        viewModel.getHeader()
        viewModel.getFooter(page)
    }




    private fun listenerActions() {
        adapter.onClick = {
            findNavController().navigate(MainScreenDirections.actionMainScreenToDetailScreen(it))

        }

        adapter.footerSeeClick = {
            findNavController().navigate(MainScreenDirections.actionMainScreenToSeeMoreScreen())
        }

    }

    private fun setAdapter() {
        binding.multiRvList.adapter = adapter
        binding.multiRvList.layoutManager = LinearLayoutManager(context)
        binding.multiRvList.setHasFixedSize(true)
    }


    private fun observe() {
        if (!header) {
            data.addSource(viewModel.headerLD) { data1 ->
                data.value = Pair(data1, data.value?.second)
            }
            header = true
        }
        if (!foot) {
            data.addSource(viewModel.footerLD) { data2 ->
                data.value = Pair(data.value?.first, data2)
            }
            foot = true
        }

        data.observe(viewLifecycleOwner) {
            val data1 = it.first
            val data2 = it.second
            if (data1 != null && data2 != null) {
                if (!firstSource) {
                    adapter.addData(data1)
                    adapter.addData(data2)
                    firstSource = true
                }
                binding.progressHome.visibility = View.GONE
            }
        }
    }


}