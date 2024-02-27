package com.admiral26.movieappmvvmauth.presentation.main_screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.admiral26.movieappmvvmauth.data.model.home.footer.FootRespons
import com.admiral26.movieappmvvmauth.data.model.home.header.HeaderRespons
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
    private val _getHead = MutableLiveData<HeaderRespons?>()
    private val _getFoot = MutableLiveData<FootRespons?>()
    override val headerLD: LiveData<HeaderRespons?> = _getHead
    override val footerLD: LiveData<FootRespons?> = _getFoot
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

    override fun getFooter() {

        viewModelScope.launch(Dispatchers.IO){
            when(val result = repositoryImp.getFootMovie()){
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