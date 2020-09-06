package com.madina.sampleapp.domain.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("vote_average")
    val voteAverage: Float,
    @SerializedName("vote_count")
    val voteCount: Int,
    val id: Int,
    val video: Boolean,
    val title: String?,
    val popularity: Float,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val adult: Boolean,
    val overview: String,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("release_date")
    val releaseDate: String?,
    var isTopRated: Boolean = false,
    var isPopular: Boolean = false,
    var isUpcoming: Boolean = false
)