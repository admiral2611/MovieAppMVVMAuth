package com.admiral26.movieappmvvmauth.data.repository

import com.admiral26.movieappmvvmauth.data.source.remote.DetailService
import com.admiral26.movieappmvvmauth.domain.repository.DetailRepository
import com.admiral26.movieappmvvmauth.util.API_KEY
import com.admiral26.movieappmvvmauth.util.ResultWrapper
import com.admiral26.movieappmvvmauth.util.parseResponse
import kotlinx.coroutines.Dispatchers
import com.admiral26.movieappmvvmauth.data.model.detail.credit.ActorResponse
import com.admiral26.movieappmvvmauth.data.model.detail.movieDetail.DetailResponse
import com.admiral26.movieappmvvmauth.data.model.detail.trailer.DetailTrailerRespons
import javax.inject.Inject

class DetailRepositoryImp @Inject constructor(
    private val service: DetailService
) : DetailRepository {
    override suspend fun getMovieDetail(id: Int): ResultWrapper<DetailResponse?, Any> {
        return parseResponse(Dispatchers.IO) {
            service.getDetail(id, API_KEY)
        }
    }

    override suspend fun getActorDetail(id: Int): ResultWrapper<ActorResponse?, Any> {
        return parseResponse(Dispatchers.IO) {
            service.getCredit(id, API_KEY)
        }
    }

    override suspend fun getTrailerDetail(id: Int): ResultWrapper<DetailTrailerRespons?, Any> {
        return parseResponse(Dispatchers.IO) {
            service.getTrailers(id, API_KEY)
        }
    }
}