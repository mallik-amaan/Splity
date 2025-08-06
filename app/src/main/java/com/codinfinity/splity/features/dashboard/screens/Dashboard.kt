package com.codinfinity.splity.features.dashboard.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.codinfinity.splity.features.dashboard.widgets.CardWidget
import com.codinfinity.splity.ui.components.PrimaryButton

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    topLevelController: NavController) {
    var amount by remember { mutableStateOf("") }
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
        CardWidget()
        Text(amount)
        Spacer(modifier = Modifier.height(20.dp))
       Row(
           modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.Absolute.SpaceEvenly
       ) {
           PrimaryButton(
               onClick = {
                   topLevelController.navigate("split_screen")
               },
               text = "Add Expense",
               modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
           )
           PrimaryButton(
               onClick = {},
               text = "Settle Up",
               modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
           )
           PrimaryButton(
               onClick = {},
               text = "Settle Up",
               modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
           )
       }

    }
}