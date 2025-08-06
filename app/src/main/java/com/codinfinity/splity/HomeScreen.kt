package com.codinfinity.splity

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codinfinity.splity.features.bottomNavigation.widgets.BottomNavigationBar
import com.codinfinity.splity.features.dashboard.screens.DashboardScreen
import com.codinfinity.splity.features.navigation.Screen
import com.codinfinity.splity.features.profile.screens.ProfileScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val bottomNavController = rememberNavController()
    Scaffold (
        bottomBar = {
            BottomNavigationBar(navController = bottomNavController)
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Splity")
                }
            )
        }
    )
    {innerPadding ->
        NavHost(
            navController = bottomNavController,
            startDestination = Screen.DashboardScreen.route,
        ){
            composable(
                route = Screen.ProfileScreen.route,
            ){
                ProfileScreen(
                    topLevelController = navController,
                    navController = bottomNavController,
                    modifier = modifier.padding(innerPadding)
                )
            }
            composable(
                route = Screen.DashboardScreen.route,
            ){
                DashboardScreen(
                    topLevelController = navController,
                    navController = bottomNavController,
                    modifier = modifier.padding(innerPadding)
                )
            }
            composable(
                route = Screen.ActivityScreen.route
            ) {

            }

        }

    }
}