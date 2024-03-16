package com.admiral26.movieappmvvmauth.data.source.remote

import com.admiral26.movieappmvvmauth.data.model.auth.LoginRequest
import com.admiral26.movieappmvvmauth.data.model.auth.SessionRequest
import com.admiral26.movieappmvvmauth.data.model.profil.ProfileResponse
import com.admiral26.movieappmvvmauth.data.model.profil.logOut.LogOutRequest
import com.admiral26.movieappmvvmauth.data.model.profil.logOut.LogOutResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Query

interface ProfileService {
    @GET("/3/account")
    suspend fun getAccountDetail(
        @Query("api_key") apiKey: String,
        @Query("session_id") sessionId: String
    ): Response<ProfileResponse?>

    @HTTP(method = "DELETE", path = "/3/authentication/session", hasBody = true)
    suspend fun logOut(
        @Query("api_key") apiKey: String,
        @Body body: LogOutRequest
    ): Response<LogOutResponse?>


}