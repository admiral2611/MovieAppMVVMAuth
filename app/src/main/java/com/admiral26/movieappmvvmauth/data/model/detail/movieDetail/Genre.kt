package com.admiral26.movieappmvvmauth.data.model.detail.movieDetail


import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    val id: Int, // 18
    @SerializedName("name")
    val name: String // Drama
)