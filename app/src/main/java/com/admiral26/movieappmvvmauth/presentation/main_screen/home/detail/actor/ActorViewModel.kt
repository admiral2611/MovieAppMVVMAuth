package com.admiral26.movieappmvvmauth.presentation.main_screen.home.detail.actor

import androidx.lifecycle.LiveData
import com.admiral26.movieappmvvmauth.data.model.detail.actor.detail.ActorDetailResponse
import com.admiral26.movieappmvvmauth.data.model.detail.actor.image.ActorImageResponse

interface ActorViewModel {

    val getImageLd: LiveData<ActorImageResponse?>
    val getDetailLd: LiveData<ActorDetailResponse?>
    fun getActorImage(id: Int)
    fun getActorDetail(id: Int)
}