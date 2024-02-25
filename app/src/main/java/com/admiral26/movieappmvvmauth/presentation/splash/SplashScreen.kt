package com.admiral26.movieappmvvmauth.presentation.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.admiral26.movieappmvvmauth.R
import com.admiral26.movieappmvvmauth.base.BaseFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashScreen : BaseFragment(R.layout.screen_splash) {
    override fun onCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            delay(4000)
            findNavController().navigate(
                SplashScreenDirections.actionSplashScreenToSignUpScreen()
            )
        }

    }
}