package com.naomi.pruebabbva.ui.screen.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.naomi.pruebabbva.R
import com.naomi.pruebabbva.domain.entities.User

@Composable
fun UserProfile(modifier: Modifier = Modifier, user:User? = null) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        if(user?.urlImage?.isNotBlank() == true){
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(user?.urlImage)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_profile),
                contentDescription = "Img Profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(CircleShape)
                    .size(200.dp),
            )
        }else{
            Image(
                painter = rememberAsyncImagePainter(model = R.drawable.ic_profile),
                contentDescription = "Logo o imagen",
                modifier = Modifier
                    .size(200.dp)
                    .padding(bottom = 50.dp)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))
        DataCard(
            modifier = Modifier.fillMaxWidth(),
            user = user
        )
    }
}