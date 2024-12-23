package com.naomi.pruebabbva.ui.screen.splash

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.naomi.pruebabbva.ui.screen.splash.components.BackgroundSplash
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navigateTo: () -> Unit) {
    Scaffold { innerPadding ->
        SplashBody(
            navigateTo = navigateTo,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}
@Composable
fun SplashBody(navigateTo: () -> Unit, modifier: Modifier = Modifier.fillMaxSize()) {
    LaunchedEffect(true) {
        delay(2000)
        navigateTo()
    }
    BackgroundSplash(modifier)
}
