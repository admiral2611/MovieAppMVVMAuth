package com.admiral26.movieappmvvmauth.data.model.auth


import com.google.gson.annotations.SerializedName

data class SessionRequest(
    @SerializedName("request_token")
    val requestToken: String // 6bc047b88f669d1fb86574f06381005d93d3517a
)