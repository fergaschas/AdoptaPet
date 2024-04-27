package com.fgascon.adoptapet.pet.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fgascon.adoptapet.pet.presentation.composables.LazyRowOfPetTypes
import com.fgascon.adoptapet.pet.presentation.composables.LocationText
import com.fgascon.adoptapet.pet.presentation.composables.SearchBarWithFilters


@Composable
fun LandingScreen(
    state: State<LandingState>,
    onQueryChanged: (String) -> Unit,
    onFilterChanged: (SearchFilter) -> Unit,
    onChangeLocation: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        LocationText(
            city = state.value.userLocation.city.ifEmpty { "City" },
            country = state.value.userLocation.country.ifEmpty { "Country" },
            onClick = { onChangeLocation() },
        )
        Spacer(modifier = Modifier.height(16.dp))

        SearchBarWithFilters(
            query = state.value.query,
            onQueryChanged = { onQueryChanged(it) },
            onFilterChanged = { onFilterChanged(it) },
        )
        Spacer(modifier = Modifier.height(32.dp))

        LazyRowOfPetTypes()
        Spacer(modifier = Modifier.size(32.dp))

        Text(text = "Adopt a pet", fontSize = 32.sp)
        Spacer(modifier = Modifier.size(32.dp))

        LazyColumn {
            item {
                Text(
                    text = "Adopt a Pet",
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
            items(state.value.filteredPets.ifEmpty { state.value.pets }) { pet ->
                PetListItem(
                    pet = pet,
                    onNavigateToDetails = { },
                )
            }
        }
    }
}

