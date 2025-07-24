package com.codinfinity.splity.features.navigation

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object SignupScreen : Screen("signup_screen")
    object HomeScreen : Screen("home_screen")
    object DashboardScreen : Screen("dashboard_screen")
    object SplitScreen : Screen("split_screen")
    object ProfileScreen : Screen("profile_screen")
    object ActivityScreen : Screen("activity_screen")
}