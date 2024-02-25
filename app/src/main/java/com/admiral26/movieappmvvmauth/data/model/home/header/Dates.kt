package com.admiral26.movieappmvvmauth.data.model.home.header


import com.google.gson.annotations.SerializedName

data class Dates(
    @SerializedName("maximum")
    val maximum: String, // 2024-02-28
    @SerializedName("minimum")
    val minimum: String // 2024-01-17
)