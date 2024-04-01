package com.admiral26.movieappmvvmauth.presentation.main_screen.home.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.admiral26.movieappmvvmauth.data.model.detail.credit.ActorResponse
import com.admiral26.movieappmvvmauth.data.model.detail.movieDetail.DetailResponse
import com.admiral26.movieappmvvmauth.data.model.detail.trailer.DetailTrailerRespons
import com.admiral26.movieappmvvmauth.domain.repository.DetailRepository
import com.admiral26.movieappmvvmauth.room.database.MovieDataBase
import com.admiral26.movieappmvvmauth.room.entity.MovieEntity
import com.admiral26.movieappmvvmauth.util.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModelImp @Inject constructor(
    private val repository: DetailRepository,
    private val dataBase: MovieDataBase
) : DetailViewModel, ViewModel() {
    private val _detailLd = MutableLiveData<DetailResponse?>()
    private val _creditLd = MutableLiveData<ActorResponse?>()
    private val _trailerLd = MutableLiveData<DetailTrailerRespons?>()
    private val _movieIsSave = MutableLiveData<Boolean>()
    override val detailLd: LiveData<DetailResponse?> = _detailLd
    override val creditLd: LiveData<ActorResponse?> = _creditLd
    override val trailerLd: LiveData<DetailTrailerRespons?> = _trailerLd
    override val movieIsSave: LiveData<Boolean> = _movieIsSave


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

    override fun checkIsSave(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val ids = dataBase.moviesDao().getID()
            if (ids.contains(id)) {
                _movieIsSave.postValue(true)
            } else {
                _movieIsSave.postValue(false)
            }
        }
    }

    override fun saveMovie(movie: MovieEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            dataBase.moviesDao().saveMovie(movie)
            _movieIsSave.postValue(true)
            Log.d("save1", "saveMovie: save")
        }
    }

    override fun deleteMovie(movie: MovieEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            dataBase.moviesDao().deleteMovie(movie)
            _movieIsSave.postValue(false)
            Log.d("save1", "saveMovie: delete")
        }
    }


}