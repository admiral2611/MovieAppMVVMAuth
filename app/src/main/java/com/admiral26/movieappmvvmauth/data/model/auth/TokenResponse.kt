package com.admiral26.movieappmvvmauth.data.model.auth


import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("expires_at")
    val expiresAt: String, // 2024-02-22 10:35:09 UTC
    @SerializedName("request_token")
    val requestToken: String, // 0e66601f939c43d2cf3b7e1eeafa2b75f86b334a
    @SerializedName("success")
    val success: Boolean // true
)