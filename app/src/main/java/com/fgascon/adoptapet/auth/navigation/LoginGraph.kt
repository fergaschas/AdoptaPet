package com.fgascon.adoptapet.auth.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fgascon.adoptapet.auth.login.presentation.LoginScreen
import com.fgascon.adoptapet.auth.login.presentation.LoginViewModel
import com.fgascon.adoptapet.auth.register.presentation.RegisterScreen
import com.fgascon.adoptapet.auth.register.presentation.RegisterViewModel
import com.fgascon.adoptapet.core.navigation.Screens

@Composable
fun LoginGraph(
    onUserLoggedIn: () -> Unit,
    navController: NavHostController = rememberNavController(),
) {

    NavHost(
        navController = navController,
        startDestination = Screens.LoginScreen.route,
    ) {

        composable(route = Screens.RegisterScreen.route) {
            val viewModel = RegisterViewModel()
            RegisterScreen(
                state = viewModel.state.collectAsState(),
                onEvent = { viewModel.onEvent(it) },
                onUserRegistered = {
                    navController.navigate(Screens.LoginScreen.route)
                },
                onNavigateBack = {
                    navController.popBackStack()
                },
            )
        }
        composable(route = Screens.LoginScreen.route) {
            val viewModel = LoginViewModel()
            LoginScreen(
                state = viewModel.state.collectAsState(),
                onEvent = { viewModel.onEvent(it) },
                onUserLoggedIn = {
                    onUserLoggedIn()
                },
                onNavigateToRegister = {
                    navController.navigate(Screens.RegisterScreen.route)
                },
            )
        }
    }
}