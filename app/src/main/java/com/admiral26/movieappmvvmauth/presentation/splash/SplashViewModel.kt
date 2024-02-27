package com.admiral26.movieappmvvmauth.presentation.splash

import androidx.lifecycle.LiveData

interface SplashViewModel {

    val isFirstLd:LiveData<Boolean>
    fun getIsFirst()
}