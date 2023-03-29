package com.private_projects.quzic.ui

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.private_projects.quzic.R

@Composable
fun LoginScreen() {
    val typography = MaterialTheme.typography
    var userName by remember {
        mutableStateOf("")
    }
    var userPassword by remember {
        mutableStateOf("")
    }
    var passwordIcon by remember {
        mutableStateOf(R.drawable.ic_visibility_24)
    }
    val passwordTransformation: MutableState<VisualTransformation> = remember {
        mutableStateOf(PasswordVisualTransformation())
    }
    val mainColumnModifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(horizontal = 10.dp, vertical = 30.dp)
    val context = LocalContext.current
    Column(modifier = mainColumnModifier) {
        Text(
            text = stringResource(R.string.system_enter_title), style = typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(60.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(R.string.user_name), style = typography.titleLarge
            )
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedTextField(
                value = userName, singleLine = true, label = {
                    Text(text = stringResource(R.string.enter_name_label))
                },
                onValueChange = { newText ->
                    userName = newText
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(R.string.user_password), style = typography.titleLarge
            )
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedTextField(
                value = userPassword,
                singleLine = true,
                visualTransformation = passwordTransformation.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    Icon(painter = painterResource(id = passwordIcon),
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            passwordTransformation.value =
                                if (passwordTransformation.value ==
                                    PasswordVisualTransformation()
                                ) VisualTransformation.None
                                else PasswordVisualTransformation()
                            passwordIcon = changePasswordIcon(passwordIcon)
                        })
                },
                label = {
                    Text(text = stringResource(R.string.enter_password_label))
                },
                onValueChange = { newText ->
                    userPassword = newText
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            OutlinedButton(
                onClick = {
                    Toast.makeText(context, "ENTER!", Toast.LENGTH_SHORT).show()
                },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.enter_button_text),
                    style = typography.titleLarge
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            OutlinedButton(
                onClick = {
                    Toast.makeText(context, "REGISTRATION!", Toast.LENGTH_SHORT).show()
                },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.registration_button_text),
                    style = typography.titleLarge
                )
            }
        }
    }
}

private fun changePasswordIcon(id: Int): Int {
    return when (id) {
        R.drawable.ic_visibility_24 -> R.drawable.ic_visibility_off_24
        else -> R.drawable.ic_visibility_24
    }
}