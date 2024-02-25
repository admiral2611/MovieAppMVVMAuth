package com.admiral26.movieappmvvmauth.data.source.remote

import com.admiral26.movieappmvvmauth.data.model.auth.TokenResponse
import com.admiral26.movieappmvvmauth.data.model.auth.LoginRequest
import com.admiral26.movieappmvvmauth.data.model.auth.SessionRequest
import com.admiral26.movieappmvvmauth.data.model.auth.SessionRespons
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthService {
    @GET("3/authentication/token/new")
    suspend fun createToken(@Query("api_key")apiKey: String): Response<TokenResponse?>

    @POST("/3/authentication/token/validate_with_login")
    suspend fun login(
        @Body body: LoginRequest,
        @Query("api_key") apiKey: String
    ): Response<TokenResponse?>

    @POST("/3/authentication/session/new")
    suspend fun createSession(
        @Body body: SessionRequest,
        @Query("api_key") apiKey: String
    ): Response<SessionRespons?>

}