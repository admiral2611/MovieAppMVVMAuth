package com.admiral26.movieappmvvmauth.presentation.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.admiral26.movieappmvvmauth.R
import com.admiral26.movieappmvvmauth.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashScreen : BaseFragment(R.layout.screen_splash) {
    private val viewModel: SplashViewModel by viewModels<SplashViewModelImp>()
    override fun onCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getIsFirst()
        observe()

    }

    private fun observe() {
        viewModel.isFirstLd.observe(viewLifecycleOwner) {
            Log.d("TAGbool", "observe: $it")
            lifecycleScope.launch {
                delay(4000)
                //findNavController().navigate(SplashScreenDirections.actionSplashScreenToSignUpScreen())
                if (it) {
                    findNavController().navigate(SplashScreenDirections.actionSplashScreenToSignUpScreen())
                } else {
                   findNavController().navigate(SplashScreenDirections.actionSplashScreenToMainScreen())
                }
            }
        }
    }
}