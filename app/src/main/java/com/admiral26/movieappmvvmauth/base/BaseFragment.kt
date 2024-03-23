package com.admiral26.movieappmvvmauth.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.zip.Inflater

@AndroidEntryPoint
abstract class BaseFragment(@LayoutRes view: Int) : Fragment(view) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onCreated(view, savedInstanceState)
    }

    abstract fun onCreated(view: View, savedInstanceState: Bundle?)
}