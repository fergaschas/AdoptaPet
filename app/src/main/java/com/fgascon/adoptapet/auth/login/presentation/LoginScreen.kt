package com.fgascon.adoptapet.auth.login.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.fgascon.adoptapet.auth.login.presentation.LoginEvent.ChangeEmail
import com.fgascon.adoptapet.auth.login.presentation.LoginEvent.ChangePassword
import com.fgascon.adoptapet.auth.login.presentation.LoginEvent.Login

@Composable
fun LoginScreen(
    state: State<LoginState>,
    onEvent: (LoginEvent) -> Unit,
    onUserLoggedIn: () -> Unit,
    onNavigateToRegister: () -> Unit,
) {
    if(state.value.isUserLoggedIn) {
        onUserLoggedIn()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            modifier = Modifier.width(200.dp),
            text = "Login",
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

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Remember me")

            var switchState by remember {
                mutableStateOf(false)
            }
            Switch(checked = switchState, onCheckedChange = {
                switchState = it
            })
        }

        Button(
            onClick = {
                onEvent(Login)
            },
            Modifier
                .fillMaxWidth()
                .height(50.dp),
        ) {
            Text(text = "Sign In", fontWeight = FontWeight.Bold)
        }
        Button(
            onClick = {
                onNavigateToRegister()
            },
            Modifier
                .fillMaxWidth()
                .height(50.dp),
        ) {
            Text(text = "Register", fontWeight = FontWeight.Bold)
        }
    }

}
