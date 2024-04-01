package com.admiral26.movieappmvvmauth.data.source.remote

import com.admiral26.movieappmvvmauth.data.model.home.footer.FootResponse
import com.admiral26.movieappmvvmauth.data.model.home.header.HeaderResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/3/movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") apiKey: String,
        @Query("pageSize") size: Int,
        @Query("page") page: Int
    ): Response<HeaderResponse?>

    @GET("/3/movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String,
        @Query("pageSize") size: Int,
        @Query("page") page: Int
    ): Response<FootResponse?>

}