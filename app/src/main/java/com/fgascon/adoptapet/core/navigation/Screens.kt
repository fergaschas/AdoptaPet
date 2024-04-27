package com.fgascon.adoptapet.core.navigation

sealed class Screens (
    val route: String,
) {
    //Application
    data object SplashScreen : Screens("splash")
    data object LoginGraph : Screens("login_graph")
    data object MainGraph : Screens("main_graph")

    //Login
    data object LoginScreen : Screens("login")
    data object RegisterScreen : Screens("register")

    //Main
    data object HomeScreen : Screens("home")
    data object AddPetScreen : Screens("add_pet")
    data object PetDetailsScreen : Screens("details/{petId}"){
        fun withId(id: String): String = "details/${id}"
    }

    //HomeBottomBar
    data object PetListScreen : Screens("pet_list")
    data object MapScreen : Screens("map")
    data object ProfileScreen : Screens("profile")

    data object LandingScreen : Screens("landing")
    data object ChangeLocationScreen : Screens("change_location")
}
