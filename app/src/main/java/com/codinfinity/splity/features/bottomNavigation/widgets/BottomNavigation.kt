package com.codinfinity.splity.features.bottomNavigation.widgets
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoGraph
import androidx.compose.material.icons.rounded.Groups
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.codinfinity.splity.features.bottomNavigation.data.BottomNavigationDataItem
import com.codinfinity.splity.features.navigation.Screen

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier, navController: NavController) {
    val items: List<BottomNavigationDataItem> = listOf(
        BottomNavigationDataItem(
            title = "Home",
            icon = Icons.Rounded.Home,
            route = Screen.DashboardScreen.route
        ),
        BottomNavigationDataItem(
            title = "Analytics",
            icon = Icons.Rounded.AutoGraph,
            route = Screen.ProfileScreen.route
        ),
        BottomNavigationDataItem(
            title = "Profile",
            icon = Icons.Rounded.Person,
            route = Screen.ProfileScreen.route
        ),
        BottomNavigationDataItem(
            title = "Friends",
            icon = Icons.Rounded.Groups,
            route = Screen.FriendScreen.route
        )
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomAppBar(modifier = modifier) {
        Row {
            items.forEach { item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = "${item.title} Icon"
                        )
                    },
                    label = { Text(item.title) },
                    selected = currentRoute == item.route,
                    onClick = {
                        if (currentRoute != item.route) {
                            navController.navigate(item.route) {
                                // Avoid duplicating same destinations
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
            }
        }
    }
}