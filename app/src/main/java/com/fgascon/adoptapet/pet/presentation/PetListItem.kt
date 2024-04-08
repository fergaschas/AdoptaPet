package com.fgascon.adoptapet.pet.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fgascon.adoptapet.pet.domain.Pet


@Composable
fun PetListItem(
    pet: Pet,
    onNavigateToDetails: (Pet) -> Unit,
) {

    var isFavorite by remember {
        mutableStateOf(false)
    }
    ListItem(
        headlineContent = {
            Text(text = pet.name)
        },
        supportingContent = {
            Text(
                text = pet.description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        },
        leadingContent = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth(0.25f)
            ) {
                AsyncImage(
                    model = pet.images.getOrNull(0),
                    contentDescription = "",
                )
            }
        },
        trailingContent = {
            IconButton(
                onClick = { isFavorite = !isFavorite },
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = "Favorite"
                )
            }
        },
        shadowElevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onNavigateToDetails(pet)
            }
    )
}