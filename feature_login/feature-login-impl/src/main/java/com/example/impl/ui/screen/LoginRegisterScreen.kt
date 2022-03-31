package com.example.feature_login.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.feature_login.ui.viewModel.LoginRegisterScreenViewModel
import com.example.impl.LoginEntryImpl
import com.example.impl.R
import com.example.impl.utils.CheckStatus
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun LoginRegisterScreen(
    navController: NavController,
    viewModel: LoginRegisterScreenViewModel
) {
    val context = LocalContext.current
    val composableScope = rememberCoroutineScope()
    var login by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var mobile by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }
    val iconPassword = if (passwordVisibility) Icons.Rounded.Visibility else Icons.Rounded.VisibilityOff
    val iconConfirmPassword = if (confirmPasswordVisibility) Icons.Rounded.Visibility else Icons.Rounded.VisibilityOff

    Column(
//        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = stringResource(R.string.text_register),
            modifier = Modifier.padding(top = 80.dp),
        )

        OutlinedTextField(
            value = login,
            onValueChange = { login = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp),
            placeholder = { Text(text = stringResource(R.string.field_username)) },
            label = { Text(text = stringResource(R.string.field_username)) },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            placeholder = { Text(text = stringResource(R.string.field_email)) },
            label = { Text(text = stringResource(R.string.field_email)) },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White)
        )

        OutlinedTextField(
            value = mobile,
            onValueChange = { mobile = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            placeholder = { Text(text = stringResource(R.string.field_mobile_No)) },
            label = { Text(text = stringResource(R.string.field_mobile_No)) },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
            placeholder = { Text(text = stringResource(R.string.field_password)) },
            label = { Text(text = stringResource(R.string.field_password)) },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(iconPassword, stringResource(R.string.contentDescription_Visibility))
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation =
            if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
            placeholder = { Text(text = stringResource(R.string.field_confirm_password)) },
            label = { Text(text = stringResource(R.string.field_confirm_password)) },
            trailingIcon = {
                IconButton(onClick = { confirmPasswordVisibility = !confirmPasswordVisibility }) {
                    Icon(iconConfirmPassword, stringResource(R.string.contentDescription_Visibility))
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation =
            if (confirmPasswordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )
        Button(
            onClick = {
                viewModel.checkRegisterData(password, login, email, mobile, confirmPassword)
                composableScope.launch {
                    viewModel.fieldsScreenStateRegister.collect { checkRegister ->
                        when (checkRegister) {
                            CheckStatus.SUCCES -> navController.navigate(LoginEntryImpl.InternalRoutes.LOGIN)
                            CheckStatus.UNSUCCES -> Toast.makeText(
                                context,
                                R.string.invalid_password,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            },

            modifier = Modifier
                .fillMaxWidth()
                .width(80.dp)
                .padding(top = 20.dp, start = 55.dp, end = 55.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(
                    android.graphics.Color.parseColor(
                        "#FF3A3A3A"
                    )
                )
            )
        ) {
            Text(text = stringResource(R.string.button_save))
        }
    }
}
