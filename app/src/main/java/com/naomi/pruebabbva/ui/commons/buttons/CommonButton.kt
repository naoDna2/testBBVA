package com.naomi.pruebabbva.ui.commons.buttons
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CommonButton(modifier: Modifier = Modifier, enabled:Boolean = true, onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(45.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
        enabled = enabled
    ) {
        Text("Entrar", color = Color.White, fontWeight = FontWeight.Bold)
    }
}