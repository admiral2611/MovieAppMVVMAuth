package com.admiral26.movieappmvvmauth.presentation.main_screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.admiral26.movieappmvvmauth.data.model.home.footer.FootResponse
import com.admiral26.movieappmvvmauth.data.model.home.header.HeaderResponse
import com.admiral26.movieappmvvmauth.domain.repository.MovieRepository
import com.admiral26.movieappmvvmauth.util.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImp @Inject constructor(
    private val repositoryImp: MovieRepository
) : HomeViewModel, ViewModel() {
    private val _getHead = MutableLiveData<HeaderResponse?>()
    private val _getFoot = MutableLiveData<FootResponse?>()
    override val headerLD: LiveData<HeaderResponse?> = _getHead
    override val footerLD: LiveData<FootResponse?> = _getFoot
    override fun getHeader() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repositoryImp.getNowPlaying()) {
                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    _getHead.postValue(result.response)
                }
            }
        }
    }

    override fun getFooter(page: Int) {

        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repositoryImp.getFootMovie(page)) {
                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    _getFoot.postValue(result.response)
                }
            }
        }
    }
}