package com.madina.sampleapp.domain.model

data class Genre(
    val id: Int,
    val name: String
) {
    override fun toString() = name
}