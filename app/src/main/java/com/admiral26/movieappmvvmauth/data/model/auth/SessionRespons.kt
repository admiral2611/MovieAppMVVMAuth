package com.admiral26.movieappmvvmauth.data.model.auth


import com.google.gson.annotations.SerializedName

data class SessionRespons(
    @SerializedName("session_id")
    val sessionId: String, // 79191836ddaa0da3df76a5ffef6f07ad6ab0c641
    @SerializedName("success")
    val success: Boolean // true
)