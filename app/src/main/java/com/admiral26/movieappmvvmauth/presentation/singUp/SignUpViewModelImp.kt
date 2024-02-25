package com.admiral26.movieappmvvmauth.presentation.singUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.admiral26.movieappmvvmauth.data.model.auth.LoginRequest
import com.admiral26.movieappmvvmauth.data.model.auth.SessionRequest
import com.admiral26.movieappmvvmauth.data.model.auth.SessionRespons
import com.admiral26.movieappmvvmauth.data.model.auth.TokenResponse
import com.admiral26.movieappmvvmauth.data.source.local.LocalStorage
import com.admiral26.movieappmvvmauth.domain.repository.AuthRepository
import com.admiral26.movieappmvvmauth.presentation.singUp.SignUpViewModel
import com.admiral26.movieappmvvmauth.util.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModelImp @Inject constructor(
    private val repository: AuthRepository,
    private val cashe:LocalStorage) :
    SignUpViewModel,
    ViewModel() {

    private val _tokenLD = MutableLiveData<TokenResponse?>()
    private val _loginLD = MutableLiveData<TokenResponse?>()
    private val _sessionLD = MutableLiveData<SessionRespons?>()
    private val _errorLD = MutableLiveData<String?>()

    override val tokenLD: LiveData<TokenResponse?> = _tokenLD
    override val loginLD: LiveData<TokenResponse?> = _loginLD
    override val sessionLD: LiveData<SessionRespons?> = _sessionLD
    override val errorLD: LiveData<String?> = _errorLD

    override fun createToken() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.createToken()) {

                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    _tokenLD.postValue(result.response)
                }
            }
        }
    }

    override fun login(body: LoginRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.login(body)) {

                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    _loginLD.postValue(result.response)
                }
            }
        }
    }

    override fun createSession(token: SessionRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.createSession(token)) {

                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    _sessionLD.postValue(result.response)
                }
            }
        }
    }

    override fun saveSession(session: String) {
        cashe.sessionId = session
        cashe.isFirst = false
    }
}