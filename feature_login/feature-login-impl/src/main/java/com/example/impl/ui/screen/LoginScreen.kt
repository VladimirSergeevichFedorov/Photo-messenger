package com.example.feature_login

import android.graphics.Color.parseColor
import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.feature_login.ui.viewModel.LoginScreenViewModel
import com.example.impl.LoginEntryImpl
import com.example.impl.R
import com.example.impl.utils.CheckStatus
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun LoginAuthScreen(
    navController: NavController,
    viewModel: LoginScreenViewModel,
) {
    val context = LocalContext.current
    val composableScope = rememberCoroutineScope()
    var login by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val icon = if (passwordVisibility) Icons.Rounded.Visibility else Icons.Rounded.VisibilityOff
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_icon),
            contentDescription = "",
            modifier = Modifier.padding(top = 150.dp)
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
            value = password,
            onValueChange = { password = it },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
            placeholder = { Text(text = stringResource(R.string.field_password)) },
            label = { Text(text = stringResource(R.string.field_password)) },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(icon, stringResource(R.string.contentDescription_Visibility))
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation =
            if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )
        Button(
            onClick = {
                viewModel.checkLoginAndPassword(password, login)
                composableScope.launch {
                    viewModel.fieldsScreenState.collect { checkAuth ->
                        when (checkAuth) {
                            CheckStatus.SUCCES ->
                                navController.navigate(LoginEntryImpl.InternalRoutes.TAPE)
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
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(parseColor("#FF3A3A3A")))
        ) {
            Text(text = stringResource(R.string.button_login))
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Button(
                elevation = ButtonDefaults.elevation(0.dp),
                onClick = { navController.navigate(LoginEntryImpl.InternalRoutes.REGISTRATION) },
                modifier = Modifier
                    .fillMaxWidth()
                    .width(80.dp)
                    .padding(top = 20.dp, start = 55.dp, end = 55.dp, bottom = 30.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Unspecified)
            ) {
                Text(
                    text = stringResource(R.string.button_register),
                    color = Color(parseColor("#FF3A3A3A"))
                )
            }
        }
    }
}
