package com.admiral26.movieappmvvmauth.domain.repository

import com.admiral26.movieappmvvmauth.data.model.detail.actor.detail.ActorDetailResponse
import com.admiral26.movieappmvvmauth.data.model.detail.actor.image.ActorImageResponse
import com.admiral26.movieappmvvmauth.util.ResultWrapper

interface ActorRepository {
    suspend fun getImageActor(id: Int): ResultWrapper<ActorImageResponse?, Any>
    suspend fun getActorDetail(id: Int): ResultWrapper<ActorDetailResponse?, Any>
}