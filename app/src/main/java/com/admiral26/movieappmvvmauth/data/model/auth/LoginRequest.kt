package com.admiral26.movieappmvvmauth.data.model.auth


import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("password")
    val password: String, // test123
    @SerializedName("request_token")
    val requestToken: String, // 1531f1a558c8357ce8990cf887ff196e8f5402ec
    @SerializedName("username")
    val username: String // johnny_appleseed
)