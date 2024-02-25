package com.admiral26.movieappmvvmauth.data.source.remote

import com.admiral26.movieappmvvmauth.data.model.home.footer.FootRespons
import com.admiral26.movieappmvvmauth.data.model.home.header.HeaderRespons
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/3/movie/now_playing")
    suspend fun getNowPlaying(@Query("api_key")apiKey: String):Response<HeaderRespons?>

    @GET("/3/movie/popular")
   suspend fun getPopularMovie(@Query("api_key")apiKey:String):Response<FootRespons?>

}