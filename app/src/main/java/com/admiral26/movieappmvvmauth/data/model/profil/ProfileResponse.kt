package com.admiral26.movieappmvvmauth.data.model.profil


import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @SerializedName("avatar")
    val avatar: Avatar,
    @SerializedName("id")
    val id: Int, // 548
    @SerializedName("include_adult")
    val includeAdult: Boolean, // false
    @SerializedName("iso_3166_1")
    val iso31661: String, // CA
    @SerializedName("iso_639_1")
    val iso6391: String, // en
    @SerializedName("name")
    val name: String, // Travis Bell
    @SerializedName("username")
    val username: String // travisbell
)