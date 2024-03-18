package com.admiral26.movieappmvvmauth.data.model.detail.trailer


import com.google.gson.annotations.SerializedName

data class ResultTrailer(
    @SerializedName("id")
    val id: String, // 65ce700403bf840181c604a5
    @SerializedName("iso_3166_1")
    val iso31661: String, // US
    @SerializedName("iso_639_1")
    val iso6391: String, // en
    @SerializedName("key")
    val key: String, // 5fv9UdRC8eg
    @SerializedName("name")
    val name: String, // Millie Bobby Brown Reacts to the Damsel Trailer
    @SerializedName("official")
    val official: Boolean, // true
    @SerializedName("published_at")
    val publishedAt: String, // 2024-02-14T17:30:00.000Z
    @SerializedName("site")
    val site: String, // YouTube
    @SerializedName("size")
    val size: Int, // 1080
    @SerializedName("type")
    val type: String // Featurette
)