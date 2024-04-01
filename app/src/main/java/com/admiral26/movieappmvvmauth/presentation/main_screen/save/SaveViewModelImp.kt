package com.admiral26.movieappmvvmauth.presentation.main_screen.save

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.admiral26.movieappmvvmauth.room.database.MovieDataBase
import com.admiral26.movieappmvvmauth.room.entity.MovieEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SaveViewModelImp @Inject constructor(
    private val data: MovieDataBase
) : SaveViewModel, ViewModel() {
    private val _getSaveLd = MutableLiveData<List<MovieEntity>>()
    override val getSaveLd: LiveData<List<MovieEntity>> = _getSaveLd


    override fun getSave() {
        viewModelScope.launch(Dispatchers.IO) {
            val data1 = data.moviesDao().getMovie()
            _getSaveLd.postValue(data1)
        }
    }
}

