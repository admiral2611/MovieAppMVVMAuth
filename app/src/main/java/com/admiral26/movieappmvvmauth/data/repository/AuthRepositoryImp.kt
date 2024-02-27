package com.admiral26.movieappmvvmauth.data.repository

import com.admiral26.movieappmvvmauth.data.model.auth.LoginRequest
import com.admiral26.movieappmvvmauth.data.model.auth.SessionRequest
import com.admiral26.movieappmvvmauth.data.model.auth.SessionRespons
import com.admiral26.movieappmvvmauth.data.model.auth.TokenResponse
import com.admiral26.movieappmvvmauth.data.source.remote.AuthService
import com.admiral26.movieappmvvmauth.domain.repository.AuthRepository
import com.admiral26.movieappmvvmauth.util.API_KEY
import com.admiral26.movieappmvvmauth.util.ResultWrapper
import com.admiral26.movieappmvvmauth.util.parseResponse
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class AuthRepositoryImp @Inject constructor(
    private val service: AuthService
) : AuthRepository {
    override suspend fun createToken(): ResultWrapper<TokenResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.createToken(API_KEY)
        }
    }


    override suspend fun login(data: LoginRequest): ResultWrapper<TokenResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.login(data, API_KEY)
        }
    }


    override suspend fun createSession(token: SessionRequest): ResultWrapper<SessionRespons?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.createSession(token, API_KEY)
        }
    }
}