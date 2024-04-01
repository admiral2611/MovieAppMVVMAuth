package com.admiral26.movieappmvvmauth.di

import android.content.Context
import androidx.room.Room
import com.admiral26.movieappmvvmauth.room.database.MovieDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideMyAppDataBase(@ApplicationContext context: Context): MovieDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            MovieDataBase::class.java,
            "notes_database"
        ).build()
    }

}