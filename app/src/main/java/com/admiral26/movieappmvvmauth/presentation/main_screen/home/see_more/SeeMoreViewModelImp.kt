package com.admiral26.movieappmvvmauth.presentation.main_screen.home.see_more

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.admiral26.movieappmvvmauth.data.model.home.footer.FootResponse
import com.admiral26.movieappmvvmauth.domain.repository.MovieRepository
import com.admiral26.movieappmvvmauth.util.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeeMoreViewModelImp @Inject constructor(
    private val repository: MovieRepository
) : SeeMoreViewModel, ViewModel() {
    private val seeFoot = MutableLiveData<FootResponse?>()
    override val footerLD: LiveData<FootResponse?> = seeFoot
    private var page = 1


    override fun getFooter() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getFootMovie(page)) {
                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    seeFoot.postValue(result.response)
                    Log.d("page11", "getFooter: ")
                    page++
                }
            }
        }
    }
}