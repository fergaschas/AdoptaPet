package com.fgascon.adoptapet.pet.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Pets
import androidx.compose.ui.graphics.vector.ImageVector


sealed class PetTypeItem(
    val text: String,
    val icon: ImageVector
)
data object All : PetTypeItem(
    text = "All",
    icon = Icons.Outlined.Pets
)
data object Dog : PetTypeItem(
    text = "Dog",
    icon = Icons.Outlined.Pets
)
data object Cat : PetTypeItem(
    text = "Cat",
    icon = Icons.Outlined.Pets
)
data object Ferret : PetTypeItem(
    text = "Ferret",
    icon = Icons.Outlined.Pets
)
data object Other : PetTypeItem(
    text = "Other",
    icon = Icons.Outlined.Pets
)


fun listOfPetTypes() = listOf(All, Dog, Cat, Ferret, Other)