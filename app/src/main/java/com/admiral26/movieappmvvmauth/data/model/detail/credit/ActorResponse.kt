package com.admiral26.movieappmvvmauth.data.model.detail.credit


import com.google.gson.annotations.SerializedName

data class ActorResponse(
    @SerializedName("cast")
    val cast: List<Cast>,
    @SerializedName("crew")
    val crew: List<Crew>,
    @SerializedName("id")
    val id: Int // 866398
)