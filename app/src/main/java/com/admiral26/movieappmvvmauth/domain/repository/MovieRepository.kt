package com.admiral26.movieappmvvmauth.domain.repository

import com.admiral26.movieappmvvmauth.data.model.home.footer.FootRespons
import com.admiral26.movieappmvvmauth.data.model.home.header.HeaderRespons
import com.admiral26.movieappmvvmauth.util.ResultWrapper

interface MovieRepository {
    suspend fun getNowPlaying():ResultWrapper<HeaderRespons?,Any>
    suspend fun getFootMovie():ResultWrapper<FootRespons?,Any>
}