package com.fgascon.adoptapet.pet.navigation.bottom_bar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fgascon.adoptapet.core.navigation.Screens
import com.fgascon.adoptapet.location.presentation.MapScreen
import com.fgascon.adoptapet.pet.domain.Pet
import com.fgascon.adoptapet.pet.presentation.LandingScreen
import com.fgascon.adoptapet.pet.presentation.LandingViewModel

@Composable
fun HomeBottomNavGraph(
    onNavigateToPetDetails: (Pet) -> Unit,
    onNavigateToAddPet: () -> Unit,
    onNavigateToChangeLocation: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val bottomNavController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = bottomNavController)
        },
        content = { paddingValues ->
            NavHost(
                navController = bottomNavController,
                startDestination = Screens.LandingScreen.route,
                modifier = modifier.padding(paddingValues = paddingValues),
            ) {
                composable(
                    route = Screens.LandingScreen.route,
                ) {
                    val viewModel: LandingViewModel = hiltViewModel()
                    LandingScreen(
                        state = viewModel.state.collectAsState(),
                        onQueryChanged = { query -> viewModel.search(query) },
                        onFilterChanged = { filter -> viewModel.setFilter(filter) },
                        onChangeLocation = { onNavigateToChangeLocation() },
                    )
                }
                composable(
                    route = Screens.PetListScreen.route,
                ) {
                    Text(text = "Pet List Screen")
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
    )
}
