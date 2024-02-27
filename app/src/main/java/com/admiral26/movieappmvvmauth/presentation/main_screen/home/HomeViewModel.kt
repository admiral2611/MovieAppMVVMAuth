package com.admiral26.movieappmvvmauth.presentation.main_screen.home

import androidx.lifecycle.LiveData
import com.admiral26.movieappmvvmauth.data.model.home.footer.FootRespons
import com.admiral26.movieappmvvmauth.data.model.home.header.HeaderRespons

interface HomeViewModel {
    val headerLD:LiveData<HeaderRespons?>
    val footerLD:LiveData<FootRespons?>

    fun getHeader()
    fun getFooter()
}