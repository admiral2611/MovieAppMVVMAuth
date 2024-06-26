package com.admiral26.movieappmvvmauth.di

import com.admiral26.movieappmvvmauth.data.source.remote.ActorService
import com.admiral26.movieappmvvmauth.data.source.remote.AuthService
import com.admiral26.movieappmvvmauth.data.source.remote.DetailService
import com.admiral26.movieappmvvmauth.data.source.remote.MovieService
import com.admiral26.movieappmvvmauth.data.source.remote.ProfileService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @[Provides Singleton]
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @[Provides Singleton]
    fun provideMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }

    @[Provides Singleton]
    fun provideProfileService(retrofit: Retrofit): ProfileService {
        return retrofit.create(ProfileService::class.java)
    }

    @[Provides Singleton]
    fun provideDetailService(retrofit: Retrofit): DetailService {
        return retrofit.create(DetailService::class.java)
    }

    @[Provides Singleton]
    fun provideActorService(retrofit: Retrofit): ActorService {
        return retrofit.create(ActorService::class.java)
    }
}