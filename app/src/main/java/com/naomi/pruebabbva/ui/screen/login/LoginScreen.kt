package com.naomi.pruebabbva.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.naomi.pruebabbva.R
import com.naomi.pruebabbva.ui.commons.alerts.ErrorDialog
import com.naomi.pruebabbva.ui.commons.loadings.LoadingIndicator
import com.naomi.pruebabbva.ui.screen.login.components.LoginForm
import com.naomi.pruebabbva.ui.states.UiState
import com.naomi.pruebabbva.ui.viewmodels.LoginViewModel


@Composable
fun LoginScreen(navigateTo: () -> Unit) {
    Scaffold{ innerPadding ->
        LoginBody(
            navigateTo = navigateTo,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray)
                .padding(innerPadding)
        )
    }
}

@Composable
fun LoginBody(navigateTo: () -> Unit, modifier: Modifier = Modifier.fillMaxSize()) {
    val viewModel: LoginViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = R.drawable.ic_profile),
            contentDescription = "Logo o imagen",
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 50.dp)
        )
        when (uiState) {
            is UiState.Loading -> LoadingIndicator()
            is UiState.Error -> ErrorDialog(
                message = (uiState as UiState.Error).message,
                onConfirmation = { viewModel.resetState() }
            )
            else ->  LoginForm(
                navigateTo = navigateTo,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
