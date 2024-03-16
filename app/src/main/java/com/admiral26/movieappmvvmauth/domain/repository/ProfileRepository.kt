package com.admiral26.movieappmvvmauth.domain.repository

import com.admiral26.movieappmvvmauth.data.model.auth.SessionRequest
import com.admiral26.movieappmvvmauth.data.model.profil.ProfileResponse
import com.admiral26.movieappmvvmauth.data.model.profil.logOut.LogOutRequest
import com.admiral26.movieappmvvmauth.data.model.profil.logOut.LogOutResponse
import com.admiral26.movieappmvvmauth.util.ResultWrapper

interface ProfileRepository {
    suspend fun getDetail(session: String): ResultWrapper<ProfileResponse?, Any>
    suspend fun logOut(sessionId: LogOutRequest): ResultWrapper<LogOutResponse?, Any>
}