package com.codinfinity.splity

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.codinfinity.splity.features.navigation.AppNavGraph

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SplityApp(
    modifier: Modifier
) {
    val navController = rememberNavController()
    AppNavGraph(
        navController = navController,
        modifier = modifier,
    )
}