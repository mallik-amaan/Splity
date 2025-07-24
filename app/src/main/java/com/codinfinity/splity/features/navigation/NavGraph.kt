package com.codinfinity.splity.features.navigation

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.codinfinity.splity.HomeScreen
import com.codinfinity.splity.features.auth.login.LoginScreen
import com.codinfinity.splity.features.auth.signUp.SignUpScreen
import com.codinfinity.splity.features.split.screens.SplitScreen
import com.codinfinity.splity.features.split.viewmodels.SplitViewModel

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun AppNavGraph(navController: NavHostController,modifier:Modifier) {
    val splitScreenViewModel = SplitViewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
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
                viewModel = splitScreenViewModel
            )
        }

    }
}