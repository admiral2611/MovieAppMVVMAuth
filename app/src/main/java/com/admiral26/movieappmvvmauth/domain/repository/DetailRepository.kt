package com.admiral26.movieappmvvmauth.domain.repository

import com.admiral26.movieappmvvmauth.util.ResultWrapper
import com.admiral26.movieappmvvmauth.data.model.detail.credit.ActorResponse
import com.admiral26.movieappmvvmauth.data.model.detail.movieDetail.DetailResponse
import com.admiral26.movieappmvvmauth.data.model.detail.trailer.DetailTrailerRespons

interface DetailRepository {

    suspend fun getMovieDetail(id: Int): ResultWrapper<DetailResponse?, Any>
    suspend fun getActorDetail(id: Int): ResultWrapper<ActorResponse?, Any>
    suspend fun getTrailerDetail(id: Int): ResultWrapper<DetailTrailerRespons?, Any>
}