package com.ehapps.core.domain.model

data class ShowCharacter(
    val id: Int,
    val name: String,
    val status: Status,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val url: String
)

enum class Status {
    ALIVE,
    DEAD,
    UNKNOWN
}