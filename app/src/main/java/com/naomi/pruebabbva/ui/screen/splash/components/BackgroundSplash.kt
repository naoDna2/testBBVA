package com.naomi.pruebabbva.ui.screen.splash.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.naomi.pruebabbva.R

@Composable
fun BackgroundSplash(modifier: Modifier = Modifier){
    Image(
        painter = painterResource(id = R.drawable.ic_bbva),
        contentDescription = "Logotipo",
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}
