package com.admiral26.movieappmvvmauth.data.model.detail.movieDetail


import com.google.gson.annotations.SerializedName

data class ProductionCountry(
    @SerializedName("iso_3166_1")
    val iso31661: String, // US
    @SerializedName("name")
    val name: String // United States of America
)