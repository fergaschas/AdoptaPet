package com.fgascon.adoptapet.pet.navigation.bottom_bar

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fgascon.adoptapet.core.navigation.Screens
import com.fgascon.adoptapet.map.presentation.MapScreen
import com.fgascon.adoptapet.pet.domain.GetPetsUseCase
import com.fgascon.adoptapet.pet.domain.Pet
import com.fgascon.adoptapet.pet.presentation.PetListScreen
import com.fgascon.adoptapet.pet.presentation.PetListViewModel

@Composable
fun HomeBottomNavGraph(
    onNavigateToPetDetails: (Pet) -> Unit,
    onNavigateToAddPet: () -> Unit,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.PetListScreen.route,
        modifier = modifier,
    ) {
        composable(
            route = Screens.PetListScreen.route,
        ) {
            val viewModel = PetListViewModel(GetPetsUseCase())
            PetListScreen(
                state = viewModel.state.collectAsState(),
                onNavigateToAddPet = { onNavigateToAddPet() },
                onNavigateToDetails = { pet -> onNavigateToPetDetails(pet) },
            )
        }
        composable(
            route = Screens.MapScreen.route,
        ) {
            MapScreen()
        }
        composable(
            route = Screens.ProfileScreen.route,
        ) {
            Text(text = "Profile Screen")
        }

    }
}
