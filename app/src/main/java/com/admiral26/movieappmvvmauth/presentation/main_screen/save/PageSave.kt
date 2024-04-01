package com.admiral26.movieappmvvmauth.presentation.main_screen.save

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.admiral26.movieappmvvmauth.R
import com.admiral26.movieappmvvmauth.adapter.save.SaveAdapter
import com.admiral26.movieappmvvmauth.base.BaseFragment
import com.admiral26.movieappmvvmauth.databinding.SavePageBinding
import com.admiral26.movieappmvvmauth.presentation.main_screen.MainScreenDirections

class PageSave : BaseFragment(R.layout.save_page) {
    private val viewModel: SaveViewModel by viewModels<SaveViewModelImp>()
    private val binding by viewBinding(SavePageBinding::bind)
    private val adapter by lazy { SaveAdapter() }
    override fun onCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getSave()
        observe()
        setAdapter()
        listenerActions()

    }

    private fun listenerActions() {

        adapter.onClick = {
            findNavController().navigate(MainScreenDirections.actionMainScreenToDetailScreen(it))
        }

        requireActivity().onBackPressedDispatcher.addCallback {

        }
    }

    private fun setAdapter() {
        binding.rvListSave.adapter = adapter
        binding.rvListSave.layoutManager = LinearLayoutManager(context)
    }

    private fun observe() {
        viewModel.getSaveLd.observe(viewLifecycleOwner) {
            adapter.setDataFoot(it)
        }
    }
}