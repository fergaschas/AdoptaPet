package com.fgascon.adoptapet.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fgascon.adoptapet.auth.navigation.LoginGraph
import com.fgascon.adoptapet.splash.presentation.SplashScreen

@Composable
fun ApplicationGraph(
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = Screens.MainGraph.route
    ) {
        composable(route = Screens.SplashScreen.route) {
            SplashScreen {
                navController.navigate(Screens.MainGraph.route) {
                    popUpTo(Screens.SplashScreen.route) {
                        inclusive = true
                    }
                }
            }
        }
        composable(route = Screens.LoginGraph.route) {
            LoginGraph(
                onUserLoggedIn = { navController.navigate(Screens.MainGraph.route) }
            )
        }
        composable(route = Screens.MainGraph.route) {
            MainGraph(
                onUserLoggedOut = { navController.navigate(Screens.LoginGraph.route) }
            )
        }
    }
}