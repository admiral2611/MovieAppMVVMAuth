package com.admiral26.movieappmvvmauth.di

import android.content.Context
import com.admiral26.movieappmvvmauth.data.source.local.LocalStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StorageModel {
    @[Provides Singleton]
    fun provideLocalStorage(@ApplicationContext context: Context):LocalStorage{
        return LocalStorage(context)
    }
}