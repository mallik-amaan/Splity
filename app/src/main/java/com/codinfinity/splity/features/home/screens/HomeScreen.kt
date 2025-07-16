package com.codinfinity.splity.features.home.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.codinfinity.splity.features.customKeyboard.widgets.CustomKeyboard
import com.codinfinity.splity.features.home.widgets.CardWidget

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var amount by remember { mutableStateOf("") }
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        CardWidget()
        Text(amount)

    }
}