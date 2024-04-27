package com.fgascon.adoptapet.pet.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.fgascon.adoptapet.pet.presentation.SearchFilter

@Composable
fun SearchBarWithFilters(
    query: String,
    onQueryChanged: (String) -> Unit,
    onFilterChanged: (SearchFilter) -> Unit,
) {
    OutlinedTextField(
        value = query,
        onValueChange = {
            onQueryChanged(it)
        },
        label = { Text(text = "Search") },
        trailingIcon = {
            var expanded by remember { mutableStateOf(false) }
            IconButton(onClick = {
                expanded = true
            }) {
                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Filter by city") },
                        onClick = {
                            onFilterChanged(SearchFilter.BY_CITY)
                            expanded = false
                        })
                }
                Icon(
                    imageVector = Icons.Outlined.FilterList,
                    contentDescription = null
                )
            }
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(),
    )
}
