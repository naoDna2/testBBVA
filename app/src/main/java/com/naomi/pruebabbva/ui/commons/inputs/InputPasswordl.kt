package com.naomi.pruebabbva.ui.commons.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun InputPassword(
    value: String,
    onPasswordChange: (String) -> Unit = {},
    label: String = "Contraseña",
    placeholder: String = "Ingrese su contraseña",
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .background(Color.Gray),
    imeAction: ImeAction = ImeAction.Next
) {
    var passwordVisibility by remember{ mutableStateOf(false) }

    TextField(
        value = value,
        onValueChange = onPasswordChange,
        label = { Text(label, color = Color.Black) },
        placeholder = { Text(placeholder, color = Color.Black) },
        modifier = modifier,
        textStyle = TextStyle(color = Color.Black),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(
                    imageVector = if (passwordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = "Mostrar/ocultar contraseña"
                )
            }
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Green
        )
    )
}
