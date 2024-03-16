package com.admiral26.movieappmvvmauth.data.source.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import uz.salikhdev.movedb.core.model.actor.actor_list.ActorResponse
import uz.salikhdev.movedb.core.model.detail.DetailResponse

interface DetailService {
    @GET("/3/movie/{movie_id}")
    suspend fun getDetail(
        @Path("movie_id") id: Int,
        @Query("apiKey") apiKey: String
    ): Response<DetailResponse?>


    @GET("/3/movie/{movie_id}/credits")
    suspend fun getCredit(
        @Path("movie_id") id: Int,
        @Query("apiKey") apiKey: String
    ): Response<ActorResponse?>
}