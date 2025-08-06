package com.codinfinity.splity.features.addFriend

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.codinfinity.splity.features.addFriend.viewmodels.AddFriendViewModel
import com.codinfinity.splity.features.addFriend.widgets.FriendTile
import com.codinfinity.splity.ui.components.CustomTextField
import com.codinfinity.splity.ui.components.PrimaryButton


@Composable
fun AddFriend(
    modifier: Modifier = Modifier,
    viewModel: AddFriendViewModel = hiltViewModel()
    ) {
    val email = viewModel.email.collectAsState(initial = "")
    val isLoading = viewModel.isLoading.collectAsState(initial = false)
    val result = viewModel.result.collectAsState(initial = null)
    Column(
        modifier = modifier
    ) {
        CustomTextField(
            onClick = {},
            placeholder = "email",
            icon = Icons.Rounded.Person,
            value = email.value,
            onValueChange = {
                viewModel.onEmailChange(it)
            }
        )
        if (isLoading.value) CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )
        else
            PrimaryButton(
                onClick = {
                    viewModel.searchUser(email.value)
                },
                modifier = Modifier.padding(16.dp),
                text = "Search",
            )

        if (result.value != null) {
            FriendTile(
                user = result.value!!,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}