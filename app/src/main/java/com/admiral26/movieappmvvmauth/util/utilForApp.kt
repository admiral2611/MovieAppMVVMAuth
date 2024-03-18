package com.admiral26.movieappmvvmauth.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

const val BASE_URL="https://api.themoviedb.org/"
const val API_KEY = "a0e3447698d4beea2f977f2773c07559"


fun ShapeableImageView.avatar(url:String){
    Glide.with(this.context)
        .load("https://image.tmdb.org/t/p/w500${url}")
        .into(this)
}

fun ImageView.poster(url:String){
    Glide.with(this.context)
        .load("https://image.tmdb.org/t/p/original${url}")
        .into(this)
}

val genres = mapOf(
    28 to "Action",
    12 to "Adventure",
    16 to "Animation",
    35 to "Comedy",
    80 to "Crime",
    99 to "Documentary",
    18 to "Drama",
    10751 to "Family",
    14 to "Fantasy",
    36 to "History",
    27 to "Horror",
    10402 to "Music",
    9648 to "Mystery",
    10749 to "Romance",
    878 to "Science Fiction",
    10770 to "TV Movie",
    53 to "Thriller",
    10752 to "War",
    37 to "Western",
)

fun getGenre(genre: Int): String {
    return genres[genre] ?: "No Genre"
}