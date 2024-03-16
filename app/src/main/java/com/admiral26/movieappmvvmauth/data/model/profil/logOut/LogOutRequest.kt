package com.admiral26.movieappmvvmauth.data.model.profil.logOut


import com.google.gson.annotations.SerializedName

data class LogOutRequest(
    @SerializedName("session_id")
    val sessionId: String // 2629f70fb498edc263a0adb99118ac41f0053e8c
)