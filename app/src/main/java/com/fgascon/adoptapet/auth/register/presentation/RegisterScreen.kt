package com.fgascon.adoptapet.auth.register.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fgascon.adoptapet.R
import com.fgascon.adoptapet.auth.core.presentation.PasswordField
import com.fgascon.adoptapet.auth.register.presentation.RegisterEvent.ChangeEmail
import com.fgascon.adoptapet.auth.register.presentation.RegisterEvent.ChangePassword
import com.fgascon.adoptapet.auth.register.presentation.RegisterEvent.ChangePassword2
import com.fgascon.adoptapet.auth.register.presentation.RegisterEvent.Register

@Composable
fun RegisterScreen(
    state: State<RegisterState>,
    onEvent: (RegisterEvent) -> Unit,
    onUserRegistered: () -> Unit,
    onNavigateBack: () -> Unit
) {
    if (state.value.isUserRegistered) {
        onUserRegistered()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start
    ) {
        IconButton(onClick = { onNavigateBack() }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null
            )
        }

        Text(
            modifier = Modifier.width(200.dp),
            text = "Register",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )

        TextField(
            value = state.value.email,
            onValueChange = { newText -> onEvent(ChangeEmail(newText)) },
            label = {
                Text(text = stringResource(R.string.label_email))
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
        )


        PasswordField(
            password = state.value.password,
            onChangePassword = { onEvent(ChangePassword(it)) }
        )
        PasswordField(
            password = state.value.password2,
            onChangePassword = { onEvent(ChangePassword2(it)) },
            label = "Repeat password"
        )

        Button(
            onClick = {
                onEvent(Register)
            },
            Modifier
                .fillMaxWidth()
                .height(50.dp),
        ) {
            Text(text = "Register", fontWeight = FontWeight.Bold)
        }
    }

}

