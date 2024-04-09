package com.fgascon.adoptapet.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fgascon.adoptapet.pet.domain.GetPetByIdUseCase
import com.fgascon.adoptapet.pet.presentation.AddPetScreen
import com.fgascon.adoptapet.pet.presentation.HomeScreen
import com.fgascon.adoptapet.pet.presentation.PetDetailsScreen
import com.fgascon.adoptapet.pet.presentation.PetDetailsViewModel


@Composable
fun MainGraph(
    onUserLoggedOut: () -> Unit,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(
                onNavigateToPetDetails = { pet ->
                    navController.navigate(Screens.PetDetailsScreen.withId(pet.id))
                },
                onNavigateToAddPet = {
                    navController.navigate(Screens.AddPetScreen.route)
                }
            )
        }
        composable(route = Screens.AddPetScreen.route) {
            AddPetScreen()
        }
        composable(
            route = Screens.PetDetailsScreen.route,
            arguments = listOf(navArgument("petId") { type = NavType.StringType })
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString("petId")?.let { id ->
                val viewModel =
                    PetDetailsViewModel(
                        getPetUseCase = GetPetByIdUseCase(),
                        id = id
                    )
                PetDetailsScreen(state = viewModel.state.collectAsState())
            }
        }
    }
}
