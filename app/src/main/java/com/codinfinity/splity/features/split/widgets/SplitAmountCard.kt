package com.codinfinity.splity.features.split.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun SplitAmountCard(
    modifier: Modifier = Modifier,
    amount:String,
    onSplitClick: () -> Unit
    ) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Type the Amount to split")
        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 30.dp)
                .height(2.dp)
                .background(Color.DarkGray)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onPrimary)
            ){
                Icon(Icons.Rounded.Add,
                    contentDescription = "Add",
                    tint = MaterialTheme.colorScheme.onBackground
                    )

            }
            Text(
                "$ ${amount}"
            )

            IconButton(
                onClick = {},
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onPrimary)
            ){
                Icon(Icons.Rounded.Remove,
                    contentDescription = "Remove",
                    tint = MaterialTheme.colorScheme.onBackground
                )            }
        }
        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 5.dp)
                .height(2.dp)
                .background(MaterialTheme.colorScheme.surface)
        )
        TextButton(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp)
                .background(MaterialTheme.colorScheme.tertiary),
            onClick = onSplitClick) {
            Text("Split Payment",
                modifier.padding(8.dp),
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onTertiary
                ))
        }
    }

}