package com.fgascon.adoptapet.pet.navigation.bottom_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.fgascon.adoptapet.core.navigation.Screens

sealed class BottomNavItem(val label: String, val icon: ImageVector, val route: String) {

    data object PetList : BottomNavItem(
        "Home",
        Icons.Filled.Home,
        Screens.PetListScreen.route
    )

    data object Map : BottomNavItem(
        "Map",
        Icons.Filled.LocationOn,
        Screens.MapScreen.route
    )

    data object Profile : BottomNavItem(
        "Profile",
        Icons.Filled.Person,
        Screens.ProfileScreen.route
    )

    data object Landing : BottomNavItem(
        "Landing",
        Icons.Filled.Home,
        Screens.LandingScreen.route
    )
}