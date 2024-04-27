package com.fgascon.adoptapet.pet.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import coil.compose.AsyncImage
import com.fgascon.adoptapet.pet.domain.Pet

@Composable
fun PetDetailsScreen(
    state: State<Pet>,
) {
    Column {

        Text(text = state.value.name)
        Text(text = state.value.type.toString())
        Text(text = state.value.age.toString())
        Text(text = state.value.description)

        state.value.images.forEach { image ->
            AsyncImage(
                model = image,
                contentDescription = null
            )
        }
    }
}