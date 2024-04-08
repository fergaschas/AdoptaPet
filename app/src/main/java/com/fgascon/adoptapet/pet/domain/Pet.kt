package com.fgascon.adoptapet.pet.domain

data class Pet(
    val id: String,
    val name: String,
    val description: String,
    val images: List<String>,
    val type: String,
    val age: Int,
) {
    companion object
}

fun emptyPet() = Pet(
    id = "",
    name = "",
    description = "",
    images = emptyList(),
    type = "",
    age = 0
)