package com.naomi.pruebabbva.ui.screen.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.naomi.pruebabbva.ui.commons.buttons.CommonButton
import com.naomi.pruebabbva.ui.commons.inputs.InputEmail
import com.naomi.pruebabbva.ui.commons.inputs.InputPassword
import com.naomi.pruebabbva.ui.viewmodels.LoginViewModel


@Composable
fun LoginForm(navigateTo: () -> Unit, modifier: Modifier = Modifier) {
    val viewModel: LoginViewModel = hiltViewModel()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var buttonEnabled by remember { mutableStateOf(false) }

    fun validateButtonState() {
        buttonEnabled = email.isNotBlank() && password.isNotBlank()
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InputEmail(
            value = email,
            label = "Correo",
            onEmailChange = {
                email = it
                validateButtonState()
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        InputPassword(
            value = password,
            onPasswordChange = {
                password = it
                validateButtonState()
            },
            imeAction = ImeAction.Done
        )
        Spacer(modifier = Modifier.height(32.dp))
        CommonButton(
            modifier = Modifier.fillMaxWidth(),
            enabled = buttonEnabled,
            onClick = {
                viewModel.login(navigateTo,email, password)
            }
        )
    }
}