package com.admiral26.movieappmvvmauth.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.admiral26.movieappmvvmauth.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}