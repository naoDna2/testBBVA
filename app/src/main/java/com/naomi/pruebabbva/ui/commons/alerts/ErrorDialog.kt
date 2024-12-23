package com.naomi.pruebabbva.ui.commons.alerts

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable

@Composable
internal fun ErrorDialog(message: String, onConfirmation: () -> Unit) {
    MainAlertDialog(
        onConfirmation = onConfirmation,
        dialogTitle = "Alerta",
        icon = Icons.Default.Warning,
        dialogText = message
    )
}