package com.admiral26.movieappmvvmauth.data.model.detail.trailer


import com.google.gson.annotations.SerializedName

data class DetailTrailerRespons(
    @SerializedName("id")
    val id: Int, // 763215
    @SerializedName("results")
    val results: List<ResultTrailer>
)