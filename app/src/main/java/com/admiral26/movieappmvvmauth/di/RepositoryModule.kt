package com.admiral26.movieappmvvmauth.di

import com.admiral26.movieappmvvmauth.data.repository.ActorRepositoryImp
import com.admiral26.movieappmvvmauth.data.repository.AuthRepositoryImp
import com.admiral26.movieappmvvmauth.data.repository.DetailRepositoryImp
import com.admiral26.movieappmvvmauth.data.repository.MovieRepositoryImp
import com.admiral26.movieappmvvmauth.data.repository.ProfileRepositoryImp
import com.admiral26.movieappmvvmauth.domain.repository.ActorRepository
import com.admiral26.movieappmvvmauth.domain.repository.AuthRepository
import com.admiral26.movieappmvvmauth.domain.repository.DetailRepository
import com.admiral26.movieappmvvmauth.domain.repository.MovieRepository
import com.admiral26.movieappmvvmauth.domain.repository.ProfileRepository
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


    @[Binds Singleton]
    fun bindProfileRepository(repositoryImp: ProfileRepositoryImp): ProfileRepository

    @[Binds Singleton]
    fun bindDetailRepository(repositoryImp: DetailRepositoryImp): DetailRepository

    @[Binds Singleton]
    fun bindActorRepository(repositoryImp: ActorRepositoryImp): ActorRepository
}