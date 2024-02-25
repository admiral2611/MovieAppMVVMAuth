package com.admiral26.movieappmvvmauth.domain.repository

import com.admiral26.movieappmvvmauth.data.model.auth.LoginRequest
import com.admiral26.movieappmvvmauth.data.model.auth.SessionRequest
import com.admiral26.movieappmvvmauth.data.model.auth.SessionRespons
import com.admiral26.movieappmvvmauth.data.model.auth.TokenResponse
import com.admiral26.movieappmvvmauth.util.ResultWrapper

interface AuthRepository {
   suspend fun createToken():ResultWrapper<TokenResponse?,Any?>
   suspend fun login(data:LoginRequest):ResultWrapper<TokenResponse?,Any?>
   suspend fun createSession(token:SessionRequest):ResultWrapper<SessionRespons?,Any?>
}