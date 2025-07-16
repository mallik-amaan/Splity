package com.codinfinity.splity.features.customKeyboard.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomKeyboard(modifier: Modifier = Modifier, textReturn: (String) -> Unit ) {
    var amount by remember { mutableStateOf("") }
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        ),
        modifier = Modifier.fillMaxWidth()
            .clip(
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp,
                )
            ),
    ) {
        Spacer(Modifier.height(40.dp))
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
            ){
        ButtonKey("1"){
            amount += "1"
            textReturn(amount)
        }
            ButtonKey("2"){
                amount += "2"
                textReturn(amount)
            }
            ButtonKey("3"){
                amount += "3"
                textReturn(amount)
            }
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ButtonKey("4"){
                amount += "4"
                textReturn(amount)
            }
            ButtonKey("5"){
                amount += "5"
                textReturn(amount)
            }
            ButtonKey("6"){
                amount += "6"
                textReturn(amount)
            }
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ButtonKey("7"){
                amount += "7"
                textReturn(amount)
            }
            ButtonKey("8"){
                amount += "8"
                textReturn(amount)
            }
            ButtonKey("9"){
                amount += "9"
                textReturn(amount)
            }
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ButtonKey("."){
                amount += "."
                textReturn(amount)
            }
            ButtonKey("0"){
                amount += "0"
                textReturn(amount)
            }
            ButtonKey("X"){
                if (amount.isNotEmpty()) {
                    amount = amount.dropLast(1)
                    textReturn(amount)
                }
            }
        }
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
fun ButtonKey(key:String,onClick:()->Unit?) {
    Box(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 4.dp)
            .height(50.dp)
            .width(100.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick() }
            .background(
                if (key == "." || key == "X")Color.Transparent else Color.White),


    ){
        Text(key,
            modifier = Modifier.align(Alignment.Center)
            ,
            style = TextStyle(
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        ))
    }
}