package com.admiral26.movieappmvvmauth.presentation.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.admiral26.movieappmvvmauth.data.source.local.LocalStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import okhttp3.Cache
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImp @Inject constructor(private val cache: LocalStorage) : SplashViewModel,ViewModel() {
    private val _isFirstLd = MutableLiveData<Boolean>()
    override val isFirstLd: LiveData<Boolean> = _isFirstLd

    override fun getIsFirst() {
        _isFirstLd.value = cache.isFirst
    }
}