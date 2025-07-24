package com.codinfinity.splity.features.split.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SplitDetailsCard(modifier: Modifier = Modifier,
                     user:String,
                     ) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 30.dp)
                .height(60.dp)
                .background(MaterialTheme.colorScheme.surface)
        )

        Text(
            text = "To: $user"
        )
        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 30.dp)
                .height(2.dp)
                .background(MaterialTheme.colorScheme.surface)
        )
    }
}