package com.codinfinity.splity.features.split.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.codinfinity.splity.features.customKeyboard.widgets.CustomKeyboard
import com.codinfinity.splity.features.split.viewmodels.SplitViewModel
import com.codinfinity.splity.features.split.widgets.SplitAmountCard
import com.codinfinity.splity.features.split.widgets.SplitDetailsCard

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SplitScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SplitViewModel = hiltViewModel()
    ) {
    var amount by remember { mutableStateOf("") }

    Scaffold() {
        padding->
        Column (modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)
            .padding(padding),
            verticalArrangement = Arrangement.SpaceBetween
            )
        {
            SplitDetailsCard(user = "Amaan")
            SplitAmountCard(
                amount = amount,
                onSplitClick = {
                    viewModel.OnSplitClicked(
                        onComplete = {}
                    )
                }
            )
            CustomKeyboard { amount = it }
        }
    }
}