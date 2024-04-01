package com.admiral26.movieappmvvmauth.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.admiral26.movieappmvvmauth.room.dao.MovieDao
import com.admiral26.movieappmvvmauth.room.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDataBase : RoomDatabase() {

    abstract fun moviesDao(): MovieDao


}