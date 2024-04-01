package com.admiral26.movieappmvvmauth.presentation.main_screen.save

import androidx.lifecycle.LiveData
import com.admiral26.movieappmvvmauth.room.entity.MovieEntity


interface SaveViewModel {

    val getSaveLd: LiveData<List<MovieEntity>>
    fun getSave()


}