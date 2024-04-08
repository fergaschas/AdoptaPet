package com.fgascon.adoptapet.pet.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.fgascon.adoptapet.pet.domain.Pet
import com.fgascon.adoptapet.pet.navigation.bottom_bar.BottomNavigation
import com.fgascon.adoptapet.pet.navigation.bottom_bar.HomeBottomNavGraph

@Composable
fun HomeScreen(
    onNavigateToPetDetails: (Pet) -> Unit = {},
    onNavigateToAddPet: () -> Unit = {},
) {
    val bottomNavController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = bottomNavController)
        },
        content = { paddingValues ->
            HomeBottomNavGraph(
                navController = bottomNavController,
                onNavigateToPetDetails = onNavigateToPetDetails,
                onNavigateToAddPet = onNavigateToAddPet,
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}