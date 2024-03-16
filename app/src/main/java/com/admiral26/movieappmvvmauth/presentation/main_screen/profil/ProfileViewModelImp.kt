package com.admiral26.movieappmvvmauth.presentation.main_screen.profil

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.admiral26.movieappmvvmauth.data.model.auth.LoginRequest
import com.admiral26.movieappmvvmauth.data.model.auth.SessionRequest
import com.admiral26.movieappmvvmauth.data.model.profil.ProfileResponse
import com.admiral26.movieappmvvmauth.data.model.profil.logOut.LogOutRequest
import com.admiral26.movieappmvvmauth.data.model.profil.logOut.LogOutResponse
import com.admiral26.movieappmvvmauth.data.source.local.LocalStorage
import com.admiral26.movieappmvvmauth.domain.repository.ProfileRepository
import com.admiral26.movieappmvvmauth.util.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModelImp @Inject constructor(
    private val repository: ProfileRepository,
    private val cache: LocalStorage
) : ProfileViewModel, ViewModel() {
    private val _getAllDetail = MutableLiveData<ProfileResponse?>()
    private val _logOut = MutableLiveData<LogOutResponse?>()
    override val getAllDetail: LiveData<ProfileResponse?> = _getAllDetail
    override val logOut: LiveData<LogOutResponse?> = _logOut


    override fun getAllDetail() {
        val sessionId = cache.sessionId
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getDetail(sessionId)) {
                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    Log.d("TAGImp", "getAllDetail: ${result.response}")
                    _getAllDetail.postValue(result.response)
                }
            }
        }
    }

    override fun logOut() {
        val sessionId = cache.sessionId
        viewModelScope.launch(Dispatchers.IO) {
            val session=LogOutRequest(sessionId)
            when (val result = repository.logOut(session)) {
                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    Log.d("TAGImp", "getAllDetail: ${result.response}")
                    _logOut.postValue(result.response)
                }
            }
        }
    }

    override fun deleteSession() {
        cache.isFirst = true
        cache.sessionId = ""
    }


}