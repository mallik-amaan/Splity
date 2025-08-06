package com.codinfinity.splity.features.navigation

import BasicInfo
import SplashScreen
import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.codinfinity.splity.HomeScreen
import com.codinfinity.splity.features.addFriend.AddFriend
import com.codinfinity.splity.features.auth.login.LoginScreen
import com.codinfinity.splity.features.auth.signUp.EmailSentScreen
import com.codinfinity.splity.features.auth.signUp.EmailVerificationScreen
import com.codinfinity.splity.features.auth.signUp.RegistrationComplete
import com.codinfinity.splity.features.auth.signUp.SignUpScreen

import com.codinfinity.splity.features.split.screens.SplitScreen

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun AppNavGraph(navController: NavHostController,modifier:Modifier) {

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable (route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController, modifier = modifier)
        }
        composable (route = Screen.LoginScreen.route){
            LoginScreen(
                navController = navController,
                modifier = modifier,
                )
        }
        composable (route = Screen.SignupScreen.route){
            SignUpScreen(
                navController = navController,
                modifier = modifier,
            )
        }
        composable(route= Screen.SplitScreen.route) {
            SplitScreen(
                navController = navController,
                modifier = modifier,
            )
        }
        composable(
            route = Screen.AddFriendScreen.route
        ) {
            AddFriend(
                modifier = modifier,
            )
        }

        composable(route = Screen.BasicInfoScreen.route) {
            BasicInfo(
                modifier = modifier,
                navController = navController
            )
        }
        composable(route = Screen.RegistrationCompleteScreen.route) {
            RegistrationComplete(
                modifier = modifier,
                navController = navController
            )
        }

        composable(
            route = Screen.EmailVerificationScreen.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "splity://auth-callback/{authToken}"
                    action = "android.intent.action.VIEW"
                }
            )
            ) {
            backStackEntry ->
            val authToken = backStackEntry.arguments?.getString("authToken")
            EmailVerificationScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable(route = Screen.EmailSentScreen.route) {
            EmailSentScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable(route = Screen.SplashScreen.route) {
            SplashScreen(
                navController = navController,
            )
        }

    }
}