package com.example.matchbook.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matchbook.R
import com.example.matchbook.ui.theme.MatchBookTheme

@Composable
fun StartPage(
    onRegistrationClicked:()-> Unit,
    onLoginClicked:()->Unit,
    modifier: Modifier =Modifier
) {
    val ubuntu = FontFamily(Font(R.font.ubuntu_bold))
    val sports= painterResource(R.drawable.sports2)
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "MatchBook",
                modifier = modifier.padding(top = 100.dp),
                fontSize = 40.sp,
                fontFamily = ubuntu
            )
            Image(
                painter=sports,
                contentDescription=null,
                modifier=Modifier
                    .padding(top=40.dp)
                    .size(width=130.dp,height=130.dp)

            )
            
            Button(
                onClick = onRegistrationClicked,
                colors = ButtonDefaults.buttonColors(Color(0xFF006E0A)),
                modifier = Modifier
                    .padding(top = 50.dp)
                    .widthIn(230.dp)
                    .heightIn(55.dp)
            )
            {
                Text(
                    text = "Register",
                    fontSize = 24.sp,
                    color = Color.White
                )
            }


            Button(
                onClick = onLoginClicked,
                colors= ButtonDefaults.buttonColors(Color(0xFF75FF68)),

                modifier = Modifier
                    .padding(top = 50.dp)
                    .widthIn(230.dp)
                    .heightIn(55.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 24.sp,
                    color = Color.Black
                )
            }



        }
    }
}
@Preview(showBackground = true)
@Composable
fun Preview() {
    MatchBookTheme {
        StartPage({},{})
    }
}