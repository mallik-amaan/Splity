package com.codinfinity.splity.features.profile.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.QrCode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.codinfinity.splity.features.profile.widgets.ProfileCard
import com.codinfinity.splity.features.profile.widgets.ProfileScreenItem

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ProfileCard(
            name = "Aman",
            email = "example@example.com",
            imageUrl = null,
            modifier = Modifier
        )
        ProfileScreenItem(
            text = "Scan Code",
            icon = Icons.Rounded.QrCode,
            onClick = {}
        )
        ProfileScreenItem(
            text = "Scan Code",
            icon = Icons.Rounded.QrCode,
            onClick = {}
        )
        ProfileScreenItem(
            text = "Scan Code",
            icon = Icons.Rounded.QrCode,
            onClick = {}
        )
        ProfileScreenItem(
            text = "Scan Code",
            icon = Icons.Rounded.QrCode,
            onClick = {}
        )
    }
}