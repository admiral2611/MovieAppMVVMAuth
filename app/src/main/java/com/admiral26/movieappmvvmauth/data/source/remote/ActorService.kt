package com.admiral26.movieappmvvmauth.data.source.remote

import com.admiral26.movieappmvvmauth.data.model.detail.actor.detail.ActorDetailResponse
import com.admiral26.movieappmvvmauth.data.model.detail.actor.image.ActorImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ActorService {
    @GET("/3/person/{person_id}/images")
    suspend fun getActorImages(
        @Path("person_id") id: Int,
        @Query("api_key") apiKey: String
    ): Response<ActorImageResponse?>

    @GET("/3/person/{person_id}")
    suspend fun getActorDetail(
        @Path("person_id") id: Int,
        @Query("api_key") apiKey: String
    ): Response<ActorDetailResponse?>
}