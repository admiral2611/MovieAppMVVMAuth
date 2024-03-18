package com.admiral26.movieappmvvmauth.data.source.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.admiral26.movieappmvvmauth.data.model.detail.credit.ActorResponse
import com.admiral26.movieappmvvmauth.data.model.detail.movieDetail.DetailResponse
import com.admiral26.movieappmvvmauth.data.model.detail.trailer.DetailTrailerRespons

interface DetailService {
    @GET("/3/movie/{movie_id}")
    suspend fun getDetail(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String
    ): Response<DetailResponse?>


    @GET("/3/movie/{movie_id}/credits")
    suspend fun getCredit(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String
    ): Response<ActorResponse?>

    @GET("3/movie/{movie_id}/videos")
    suspend fun getTrailers(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String
    ): Response<DetailTrailerRespons?>
}