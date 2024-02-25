package com.admiral26.movieappmvvmauth.di

import com.admiral26.movieappmvvmauth.data.repository.AuthRepositoryImp
import com.admiral26.movieappmvvmauth.data.repository.MovieRepositoryImp
import com.admiral26.movieappmvvmauth.domain.repository.AuthRepository
import com.admiral26.movieappmvvmauth.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindAuthRepository(repositoryImp: AuthRepositoryImp): AuthRepository

    @Binds
    @Singleton
    fun bindMovieRepository(repositoryImp: MovieRepositoryImp): MovieRepository
}