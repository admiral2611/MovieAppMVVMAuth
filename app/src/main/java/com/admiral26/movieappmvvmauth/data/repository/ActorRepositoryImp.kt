package com.admiral26.movieappmvvmauth.data.repository

import com.admiral26.movieappmvvmauth.data.model.detail.actor.detail.ActorDetailResponse
import com.admiral26.movieappmvvmauth.data.model.detail.actor.image.ActorImageResponse
import com.admiral26.movieappmvvmauth.data.source.remote.ActorService
import com.admiral26.movieappmvvmauth.domain.repository.ActorRepository
import com.admiral26.movieappmvvmauth.util.API_KEY
import com.admiral26.movieappmvvmauth.util.ResultWrapper
import com.admiral26.movieappmvvmauth.util.parseResponse
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class ActorRepositoryImp @Inject constructor(
    private val service: ActorService
) : ActorRepository {
    override suspend fun getImageActor(id: Int): ResultWrapper<ActorImageResponse?, Any> {
        return parseResponse(Dispatchers.IO) {
            service.getActorImages(id, API_KEY)
        }
    }

    override suspend fun getActorDetail(id: Int): ResultWrapper<ActorDetailResponse?, Any> {
        return parseResponse(Dispatchers.IO) {
            service.getActorDetail(id, API_KEY)
        }
    }
}