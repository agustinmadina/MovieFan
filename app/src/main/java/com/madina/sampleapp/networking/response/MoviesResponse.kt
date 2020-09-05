package com.madina.sampleapp.networking.response

import com.google.gson.annotations.SerializedName
import com.madina.sampleapp.domain.model.Movie

class MoviesResponse(
    val id: Int,
    val page: Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    val name: String,
    val public: Boolean,
    val results: List<Movie>
)