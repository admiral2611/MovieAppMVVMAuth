package com.admiral26.movieappmvvmauth.data.repository

import com.admiral26.movieappmvvmauth.data.model.auth.SessionRequest
import com.admiral26.movieappmvvmauth.data.model.profil.ProfileResponse
import com.admiral26.movieappmvvmauth.data.model.profil.logOut.LogOutRequest
import com.admiral26.movieappmvvmauth.data.model.profil.logOut.LogOutResponse
import com.admiral26.movieappmvvmauth.data.source.remote.ProfileService
import com.admiral26.movieappmvvmauth.domain.repository.ProfileRepository
import com.admiral26.movieappmvvmauth.util.API_KEY
import com.admiral26.movieappmvvmauth.util.ResultWrapper
import com.admiral26.movieappmvvmauth.util.parseResponse
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class ProfileRepositoryImp @Inject constructor(
    private val service: ProfileService
) : ProfileRepository {
    override suspend fun getDetail(session: String): ResultWrapper<ProfileResponse?, Any> {
        return parseResponse(Dispatchers.IO) {
            service.getAccountDetail(API_KEY, session)
        }
    }

    override suspend fun logOut(sessionId: LogOutRequest): ResultWrapper<LogOutResponse?, Any> {
        return parseResponse(Dispatchers.IO) {
            service.logOut(API_KEY, sessionId)
        }
    }
}