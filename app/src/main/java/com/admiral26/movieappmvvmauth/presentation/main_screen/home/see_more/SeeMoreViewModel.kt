package com.admiral26.movieappmvvmauth.presentation.main_screen.home.see_more

import androidx.lifecycle.LiveData
import com.admiral26.movieappmvvmauth.data.model.home.footer.FootResponse

interface SeeMoreViewModel {
    val footerLD: LiveData<FootResponse?>
    fun getFooter()
}