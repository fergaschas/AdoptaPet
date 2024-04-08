package com.fgascon.adoptapet.pet.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fgascon.adoptapet.pet.domain.Pet

@Composable
fun PetListScreen(
    state: State<List<Pet>>,
    onNavigateToDetails: (Pet) -> Unit,
    onNavigateToAddPet: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onNavigateToAddPet() },
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = ""
                )
            }
        },
        content = { paddingValues ->
            LazyColumn(modifier = modifier.padding(paddingValues)) {
                item {
                    Text(
                        text = "Adopt a Pet",
                        style = typography.titleLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
                items(state.value) { pet ->
                    PetListItem(
                        pet = pet,
                        onNavigateToDetails = { onNavigateToDetails(it) },
                    )
                }
            }
        }
    )
}