package com.fgascon.adoptapet.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fgascon.adoptapet.location.presentation.ChangeLocationScreen
import com.fgascon.adoptapet.location.presentation.ChangeLocationViewModel
import com.fgascon.adoptapet.pet.navigation.bottom_bar.HomeBottomNavGraph
import com.fgascon.adoptapet.pet.presentation.AddPetScreen
import com.fgascon.adoptapet.pet.presentation.PetDetailsScreen
import com.fgascon.adoptapet.pet.presentation.PetDetailsViewModel


@Composable
fun MainGraph(
    onUserLoggedOut: () -> Unit,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
        composable(route = Screens.HomeScreen.route) {
            HomeBottomNavGraph(
                onNavigateToPetDetails = { pet ->
                    navController.navigate(Screens.PetDetailsScreen.withId(pet.id))
                },
                onNavigateToAddPet = {
                    navController.navigate(Screens.AddPetScreen.route)
                },
                onNavigateToChangeLocation = {
                    navController.navigate(Screens.ChangeLocationScreen.route)
                },
            )
        }
        composable(
            route = Screens.ChangeLocationScreen.route,
        ) {
            val viewModel: ChangeLocationViewModel = hiltViewModel()
            ChangeLocationScreen(
                state = viewModel.state.collectAsState(),
                onSaveLocation = {
                    viewModel.saveLocation()
                    navController.popBackStack()
                },
                onChangeLocation = {
                    viewModel.changeLocation(it)
                }
            )
        }
        composable(route = Screens.AddPetScreen.route) {
            AddPetScreen()
        }
        composable(
            route = Screens.PetDetailsScreen.route,
            arguments = listOf(navArgument("petId") { type = NavType.StringType })
        ) {
            val viewModel: PetDetailsViewModel = hiltViewModel()
            PetDetailsScreen(state = viewModel.state.collectAsState())
        }
    }
}
