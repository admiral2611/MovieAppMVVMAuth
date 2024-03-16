package com.admiral26.movieappmvvmauth.presentation.main_screen.profil

import androidx.lifecycle.LiveData
import com.admiral26.movieappmvvmauth.data.model.profil.ProfileResponse
import com.admiral26.movieappmvvmauth.data.model.profil.logOut.LogOutResponse

interface ProfileViewModel {


    val getAllDetail: LiveData<ProfileResponse?>
    val logOut:LiveData<LogOutResponse?>
    fun getAllDetail()

    fun logOut()
    fun deleteSession()
}