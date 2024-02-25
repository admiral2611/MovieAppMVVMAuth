package com.admiral26.movieappmvvmauth.presentation.singUp

import androidx.lifecycle.LiveData
import com.admiral26.movieappmvvmauth.data.model.auth.LoginRequest
import com.admiral26.movieappmvvmauth.data.model.auth.SessionRequest
import com.admiral26.movieappmvvmauth.data.model.auth.SessionRespons
import com.admiral26.movieappmvvmauth.data.model.auth.TokenResponse

interface SignUpViewModel {
    val tokenLD: LiveData<TokenResponse?>
    val loginLD: LiveData<TokenResponse?>
    val sessionLD: LiveData<SessionRespons?>
    val errorLD: LiveData<String?>

    fun createToken()
    fun login(body: LoginRequest)
    fun createSession(token: SessionRequest)
    fun saveSession(session: String)
}