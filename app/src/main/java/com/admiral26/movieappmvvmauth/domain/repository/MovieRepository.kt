package com.admiral26.movieappmvvmauth.domain.repository

import com.admiral26.movieappmvvmauth.data.model.home.footer.FootResponse
import com.admiral26.movieappmvvmauth.data.model.home.header.HeaderResponse
import com.admiral26.movieappmvvmauth.util.ResultWrapper

interface MovieRepository {
    suspend fun getNowPlaying(): ResultWrapper<HeaderResponse?, Any>
    suspend fun getFootMovie(page: Int): ResultWrapper<FootResponse?, Any>
}