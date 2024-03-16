package com.admiral26.movieappmvvmauth.presentation.main_screen.home.detail

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.admiral26.movieappmvvmauth.R
import com.admiral26.movieappmvvmauth.base.BaseFragment
import com.admiral26.movieappmvvmauth.databinding.ScreenDetailBinding

class DetailScreen : BaseFragment(R.layout.screen_detail) {
    private val binding by viewBinding(ScreenDetailBinding::bind)
    override fun onCreated(view: View, savedInstanceState: Bundle?) {

    }
}