package com.codinfinity.splity.features.dashboard.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun CardWidget(modifier: Modifier = Modifier) {
 Card(
     modifier = modifier
         .fillMaxWidth()
         .padding(16.dp),
     shape = RoundedCornerShape(10.dp),
     colors = CardDefaults.cardColors(
         containerColor = Color.LightGray
     )
 ) {

     Column {
         Box(
             modifier = Modifier
                 .fillMaxWidth()
                 .background(Color.White)
         ) {
             Column {
                 Text(
                     text = "Total Balance",
                     modifier = Modifier.padding(16.dp),
                     style = TextStyle(
                         color = Color.Black
                     )

                 )
                 Text(
                     text = "Rs. 8000",
                     modifier = Modifier.padding(horizontal = 16.dp),
                     style = TextStyle(
                         color = Color.Black
                     )
                 )
             }
         }
         Box(
             modifier = Modifier
                 .fillMaxWidth()
                 .background(Color.Black),
             contentAlignment = Alignment.Center
         ){
             TextButton(
                 onClick = {}
             ) {
                 Row{
                     Icon(
                         Icons.Default.Add,
                         tint = Color.White,
                         contentDescription = "Add Expense"
                     )
                     Text(
                         "Add Expense"
                     )
                 }
             }
         }
     }
 }
}