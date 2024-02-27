package com.admiral26.movieappmvvmauth.adapter.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.admiral26.movieappmvvmauth.PageSave
import com.admiral26.movieappmvvmauth.PagesTicket
import com.admiral26.movieappmvvmauth.presentation.home.HomePage

class MainAdapter(fm: FragmentManager, lc: Lifecycle) : FragmentStateAdapter(fm, lc) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomePage()
            1 -> PagesTicket()
            else -> PageSave()
        }
    }
}
