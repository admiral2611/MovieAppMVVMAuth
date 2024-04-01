package com.admiral26.movieappmvvmauth.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val genreIds: Int?,
    val originalTitle: String, // Anyone But You
    val voteAverage: Double?, // 6.898
    val releaseDate: String?, // 2023-12-21
    val posterPath: String?, // /yRt7MGBElkLQOYRvLTT1b3B1rcp.jpg
) : Serializable
