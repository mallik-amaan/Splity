package com.codinfinity.splity.features.addFriend.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codinfinity.splity.data.models.UserModel
import com.codinfinity.splity.ui.components.PrimaryButton

@Composable
fun FriendTile(
    modifier: Modifier = Modifier,
    user: UserModel
) {
    OutlinedCard(
        modifier = modifier
            .fillMaxWidth()
    ){
        Column {
            Text(user.name)
            Text(user.email)
            PrimaryButton(
                onClick = {},
                text = "Add Friend",
                modifier = modifier.fillMaxWidth().padding(16.dp)
            )
        }
    }
}