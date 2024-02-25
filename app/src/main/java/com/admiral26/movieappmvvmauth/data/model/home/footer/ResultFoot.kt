package com.admiral26.movieappmvvmauth.data.model.home.footer


import com.google.gson.annotations.SerializedName

data class ResultFoot(
    @SerializedName("adult")
    val adult: Boolean, // false
    @SerializedName("backdrop_path")
    val backdropPath: String, // /nTPFkLUARmo1bYHfkfdNpRKgEOs.jpg
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("id")
    val id: Int, // 1072790
    @SerializedName("original_language")
    val originalLanguage: String, // en
    @SerializedName("original_title")
    val originalTitle: String, // Anyone But You
    @SerializedName("overview")
    val overview: String, // After an amazing first date, Bea and Ben’s fiery attraction turns ice cold — until they find themselves unexpectedly reunited at a destination wedding in Australia. So they do what any two mature adults would do: pretend to be a couple.
    @SerializedName("popularity")
    val popularity: Double, // 2086.66
    @SerializedName("poster_path")
    val posterPath: String, // /yRt7MGBElkLQOYRvLTT1b3B1rcp.jpg
    @SerializedName("release_date")
    val releaseDate: String, // 2023-12-21
    @SerializedName("title")
    val title: String, // Anyone But You
    @SerializedName("video")
    val video: Boolean, // false
    @SerializedName("vote_average")
    val voteAverage: Double, // 6.898
    @SerializedName("vote_count")
    val voteCount: Int // 573
)