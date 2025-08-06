package com.codinfinity.splity.features.auth.signUp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun RegistrationComplete(
    navController: NavController,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text("Registration Complete")
    }
}