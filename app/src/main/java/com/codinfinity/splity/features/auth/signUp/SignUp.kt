package com.codinfinity.splity.features.auth.signUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.codinfinity.splity.features.navigation.Screen
import com.codinfinity.splity.ui.components.PrimaryButton

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val email = viewModel.email.collectAsState(initial = "")
    val password = viewModel.password.collectAsState(initial = "")
    val isLoading = viewModel.isLoading.collectAsState(initial = false)
    val result = viewModel.result.collectAsState(initial = null)

    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedCard(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
        )
        {
            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                text = "Sign Up")
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp),
                value = email.value,
                onValueChange = {
                    viewModel.onEmailChange(it)
                },
                placeholder = { Text("Username") }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp),
                value = password.value,
                onValueChange = {
                    viewModel.onPasswordChange(it)
                },
                placeholder = { Text("Password")}
            )
            if (isLoading.value) CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )
            else
                PrimaryButton(
                    onClick = {
                        viewModel.onSignIn(
                            onComplete = {
                                navController.navigate(Screen.EmailSentScreen.route){
                                }
                            }
                        )
                    },
                    text = "Sign Up",
                    modifier = Modifier.fillMaxWidth()
                        .padding(16.dp)
                )

        }
    }
}