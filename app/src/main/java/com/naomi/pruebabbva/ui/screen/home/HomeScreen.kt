package com.naomi.pruebabbva.ui.screen.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.naomi.pruebabbva.domain.entities.User
import com.naomi.pruebabbva.ui.commons.alerts.ErrorDialog
import com.naomi.pruebabbva.ui.commons.loadings.LoadingIndicator
import com.naomi.pruebabbva.ui.screen.home.components.UserProfile
import com.naomi.pruebabbva.ui.states.UiState
import com.naomi.pruebabbva.ui.viewmodels.HomeViewModel

@Composable
fun HomeScreen() {
    Scaffold(
    ) { innerPadding ->
        HomeBody(
            modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun HomeBody(modifier: Modifier = Modifier.fillMaxSize()) {
    Box(
        modifier = modifier
    ) {
        val viewModel: HomeViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsState()

        LaunchedEffect(true) {
            viewModel.getProfile()
        }

        when(uiState){
            is UiState.Loading -> LoadingIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
            is UiState.Error -> ErrorDialog(
                message = (uiState as UiState.Error).message,
                onConfirmation = { viewModel.resetState() }
            )
            is UiState.Success<*> -> {
                Log.d("HomeScreen", "Success")
                val user = (uiState as UiState.Success<User>).data
                UserProfile(
                    modifier = Modifier.fillMaxSize(),
                    user = user
                )
            }
            else ->  UserProfile(
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}