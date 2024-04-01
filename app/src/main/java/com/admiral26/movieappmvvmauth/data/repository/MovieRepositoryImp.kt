package com.admiral26.movieappmvvmauth.data.repository

import com.admiral26.movieappmvvmauth.data.model.home.footer.FootResponse
import com.admiral26.movieappmvvmauth.data.model.home.header.HeaderResponse
import com.admiral26.movieappmvvmauth.data.source.remote.MovieService
import com.admiral26.movieappmvvmauth.domain.repository.MovieRepository
import com.admiral26.movieappmvvmauth.util.API_KEY
import com.admiral26.movieappmvvmauth.util.ResultWrapper
import com.admiral26.movieappmvvmauth.util.parseResponse
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val service: MovieService
) : MovieRepository {
    override suspend fun getNowPlaying(): ResultWrapper<HeaderResponse?, Any> {
        return parseResponse(Dispatchers.IO) {
            service.getNowPlaying(API_KEY, 15, 1)
        }
    }


    override suspend fun getFootMovie(page: Int): ResultWrapper<FootResponse?, Any> {
        return parseResponse(Dispatchers.IO) {
            service.getPopularMovie(API_KEY, 15, page)
        }
    }
}