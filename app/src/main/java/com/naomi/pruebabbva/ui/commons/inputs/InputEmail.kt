package com.naomi.pruebabbva.ui.commons.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun InputEmail(
    value: String,
    onEmailChange: (String) -> Unit = {},
    label: String = "Email",
    placeholder: String = "Ingrese su email",
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .background(Color.Gray),
    imeAction: ImeAction = ImeAction.Next
) {
    TextField(
        value = value,
        onValueChange = onEmailChange,
        label = { Text(label, color = Color.Black) },
        placeholder = { Text(placeholder, color = Color.Black) },
        modifier = modifier,
        textStyle = TextStyle(color = Color.Black),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = imeAction
        ),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Green
        )
    )
}
