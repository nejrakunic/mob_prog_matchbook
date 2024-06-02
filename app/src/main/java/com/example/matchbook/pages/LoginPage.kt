package com.example.matchbook.pages

import com.example.matchbook.data.AppDatabase
import com.example.matchbook.ui.theme.MatchBookTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.matchbook.MatchAppScreen
import com.example.matchbook.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LogInPage (
    onCancelClicked: () -> Unit,
    navController: NavController,
    database: AppDatabase,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val ubuntu = FontFamily(Font(R.font.ubuntu_bold))

    val loginButtonClick: () -> Unit = {
        if (email.isEmpty() || password.isEmpty()) {
            errorMessage = "Please fill in all fields"
        } else {
            MainScope().launch {
                try {
                    val existingUser = withContext(Dispatchers.IO) {
                        database.loginDao().getUserId(email)
                    }
                    if (existingUser == null) {
                        errorMessage = "User does not exist"
                    } else {
                        if (existingUser.password != password) {
                            errorMessage = "Incorrect password"
                        } else {
                            navController.navigate(MatchAppScreen.HomePage.name)
                        }
                    }
                } catch (e: Exception) {
                    errorMessage = "Error occurred: ${e.message}"
                }
            }
        }
    }


    Box (
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "MatchBook",
                fontFamily = ubuntu,
                fontSize = 45.sp,
                modifier = modifier.padding(top = 30.dp)
            )
            Text(
                text = "Log in to continue",
                fontSize = 20.sp,
                modifier = modifier.padding(top = 8.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .widthIn(280.dp),
                placeholder = {
                    Text(text = "E-mail")
                },
                leadingIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = null
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
                singleLine = true
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .widthIn(280.dp),
                placeholder = {
                    Text(text = "Password")
                },
                leadingIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = null
                        )
                    }
                },
                trailingIcon = {
                    val visibilityIcon = if (passwordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
                    IconButton(
                        onClick = { passwordVisible = !passwordVisible },
                        content = {
                            Icon(
                                imageVector = visibilityIcon,
                                contentDescription = null
                            )
                        }
                    )
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    loginButtonClick()
                    keyboardController?.hide()
                }),
                singleLine = true
            )
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(top = 8.dp)
            )
            Button(
                onClick = loginButtonClick,
                colors = ButtonDefaults.buttonColors(Color(0xFF006E0A)),
                modifier = Modifier
                    .padding(top = 10.dp)
                    .widthIn(200.dp)
                    .heightIn(50.dp)
            ) {
                Text(
                    text = "Log In",
                    fontSize = 25.sp
                )
            }
            Button(
                onClick = onCancelClicked,
                colors = ButtonDefaults.buttonColors(Color(0xFF75FF68)),
                modifier = Modifier
                    .padding(top = 16.dp)
                    .widthIn(200.dp)
                    .heightIn(50.dp)
            ) {
                Text(
                    text = "Cancel",
                    color = Color.Black,
                    fontSize = 25.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview4() {
    val context = LocalContext.current
    MatchBookTheme() {
        LogInPage({}, database = AppDatabase.getDatabase(context), navController = rememberNavController())
    }
}