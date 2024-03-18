package com.admiral26.movieappmvvmauth.presentation.main_screen.home.detail.actor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.admiral26.movieappmvvmauth.data.model.detail.actor.detail.ActorDetailResponse
import com.admiral26.movieappmvvmauth.data.model.detail.actor.image.ActorImageResponse
import com.admiral26.movieappmvvmauth.domain.repository.ActorRepository
import com.admiral26.movieappmvvmauth.util.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActorViewModelImp @Inject constructor(
    private val repository: ActorRepository
) : ActorViewModel, ViewModel() {
    private val _getImageLd = MutableLiveData<ActorImageResponse?>()
    private val _getDetailLd = MutableLiveData<ActorDetailResponse?>()
    override val getImageLd: LiveData<ActorImageResponse?> = _getImageLd
    override val getDetailLd: LiveData<ActorDetailResponse?> = _getDetailLd

    override fun getActorImage(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getImageActor(id)) {
                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    _getImageLd.postValue(result.response)
                }
            }
        }
    }

    override fun getActorDetail(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getActorDetail(id)) {
                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    _getDetailLd.postValue(result.response)
                }
            }
        }
    }
}