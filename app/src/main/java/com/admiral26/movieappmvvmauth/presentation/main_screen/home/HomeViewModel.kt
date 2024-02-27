package com.admiral26.movieappmvvmauth.presentation.main_screen.home

import androidx.lifecycle.LiveData
import com.admiral26.movieappmvvmauth.data.model.home.footer.FootResponse
import com.admiral26.movieappmvvmauth.data.model.home.header.HeaderResponse

interface HomeViewModel {
    val headerLD:LiveData<HeaderResponse?>
    val footerLD:LiveData<FootResponse?>

    fun getHeader()
    fun getFooter()
}