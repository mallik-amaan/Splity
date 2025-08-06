package com.codinfinity.splity.features.navigation

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object SignupScreen : Screen("signup_screen")
    object HomeScreen : Screen("home_screen")
    object DashboardScreen : Screen("dashboard_screen")
    object SplitScreen : Screen("split_screen")
    object ProfileScreen : Screen("profile_screen")
    object ActivityScreen : Screen("activity_screen")
    object FriendScreen : Screen("friend_screen")
    object AddFriendScreen : Screen("add_friend_screen")
    object BasicInfoScreen : Screen("basic_info_screen")
    object RegistrationCompleteScreen : Screen("registration_complete_screen")
    object EmailVerificationScreen : Screen("email_verification_screen/{authToken}")
    object EmailSentScreen : Screen("email_sent_screen")
    object SplashScreen : Screen("splash_screen")
}