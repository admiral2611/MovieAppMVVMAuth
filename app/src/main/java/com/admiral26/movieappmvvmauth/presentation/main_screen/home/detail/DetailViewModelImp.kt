package com.admiral26.movieappmvvmauth.presentation.main_screen.home.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.admiral26.movieappmvvmauth.domain.repository.DetailRepository
import com.admiral26.movieappmvvmauth.util.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.admiral26.movieappmvvmauth.data.model.detail.credit.ActorResponse
import com.admiral26.movieappmvvmauth.data.model.detail.movieDetail.DetailResponse
import com.admiral26.movieappmvvmauth.data.model.detail.trailer.DetailTrailerRespons
import javax.inject.Inject

@HiltViewModel
class DetailViewModelImp @Inject constructor(
    private val repository: DetailRepository
) : DetailViewModel, ViewModel() {
    private val _detailLd = MutableLiveData<DetailResponse?>()
    private val _creditLd = MutableLiveData<ActorResponse?>()
    private val _trailerLd = MutableLiveData<DetailTrailerRespons?>()
    override val detailLd: LiveData<DetailResponse?> = _detailLd
    override val creditLd: LiveData<ActorResponse?> = _creditLd
    override val trailerLd: LiveData<DetailTrailerRespons?> = _trailerLd


    override fun getDetailMovie(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getMovieDetail(id)) {
                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    _detailLd.postValue(result.response)
                }
            }
        }
    }

    override fun getCreditMovie(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getActorDetail(id)) {
                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    _creditLd.postValue(result.response)
                }
            }
        }
    }

    override fun getTrailerMovie(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getTrailerDetail(id)) {
                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    _trailerLd.postValue(result.response)
                }
            }
        }
    }


}