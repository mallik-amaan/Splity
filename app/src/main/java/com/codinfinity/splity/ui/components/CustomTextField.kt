package com.codinfinity.splity.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    placeholder: String,
    value:String,
    icon:ImageVector,
    onValueChange: (String) -> Unit
    ) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        value = value,
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "$icon"
            )
        },
        onValueChange = {
            onValueChange(it)
        },
        placeholder = { Text(placeholder) }
    )
}