package com.admiral26.movieappmvvmauth.presentation.main_screen.home.detail

import androidx.lifecycle.LiveData
import com.admiral26.movieappmvvmauth.data.model.detail.credit.ActorResponse
import com.admiral26.movieappmvvmauth.data.model.detail.movieDetail.DetailResponse
import com.admiral26.movieappmvvmauth.data.model.detail.trailer.DetailTrailerRespons
import com.admiral26.movieappmvvmauth.room.entity.MovieEntity

interface DetailViewModel {

    val detailLd: LiveData<DetailResponse?>
    val creditLd: LiveData<ActorResponse?>
    val trailerLd: LiveData<DetailTrailerRespons?>
    val movieIsSave: LiveData<Boolean>
    fun getDetailMovie(id: Int)
    fun getCreditMovie(id: Int)
    fun getTrailerMovie(id: Int)
    fun checkIsSave(id: Int)
    fun saveMovie(movie: MovieEntity)
    fun deleteMovie(movie: MovieEntity)
}