package com.admiral26.movieappmvvmauth.data.repository

import com.admiral26.movieappmvvmauth.data.model.home.footer.FootRespons
import com.admiral26.movieappmvvmauth.data.model.home.header.HeaderRespons
import com.admiral26.movieappmvvmauth.data.source.remote.MovieService
import com.admiral26.movieappmvvmauth.domain.repository.MovieRepository
import com.admiral26.movieappmvvmauth.util.API_KEY
import com.admiral26.movieappmvvmauth.util.ResultWrapper
import com.admiral26.movieappmvvmauth.util.parseResponse
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val service:MovieService
):MovieRepository {
    override suspend fun getNowPlaying(): ResultWrapper<HeaderRespons?, Any> {
        return parseResponse(Dispatchers.IO){
            service.getNowPlaying(API_KEY)
        }
    }

    override suspend fun getFootMovie(): ResultWrapper<FootRespons?, Any> {
        return parseResponse(Dispatchers.IO){
            service.getPopularMovie(API_KEY)
        }
    }
}