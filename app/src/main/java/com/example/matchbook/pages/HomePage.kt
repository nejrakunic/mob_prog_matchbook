package com.example.matchbook.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.matchbook.MatchAppScreen
import com.example.matchbook.MatchBookApp
import com.example.matchbook.R
import com.example.matchbook.ui.theme.MatchBookTheme

@Composable
fun HomePagee(
    navController: NavController,
    modifier: Modifier= Modifier
) {
    val cabin = FontFamily(Font(R.font.cabin))
    val boldcabin = FontFamily(Font(R.font.cabin_bold))
    val footballimg = painterResource(R.drawable.football_game)
    val basketballimg= painterResource(R.drawable._6106)
    val volleyballimg= painterResource(R.drawable.volleyball)
    val card = painterResource(R.drawable.green)

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 16.dp)
    ) {
        Column(
            modifier = modifier.fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Choose your sport",
                fontSize = 30.sp,
                modifier = modifier.padding(top = 90.dp),
                fontFamily = boldcabin
            )

            Box(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .size(width = 340.dp, height = 90.dp)
                    .background(color = Color(0xFF75FF68), shape = RoundedCornerShape(16.dp))
                    .clickable {
                        navController.navigate(MatchAppScreen.Football.name)
                    }
            ) {
                Column(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                        Text(
                            text = "Football",
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(5.dp),
                            fontFamily = boldcabin
                        )
                    Row {
                        Text(
                            text = stringResource(R.string.footballdesc),
                            modifier = Modifier
                                .size(height = 200.dp, width = 250.dp)
                                .padding(4.dp),
                            fontSize = 12.sp,
                            textAlign = TextAlign.Left,
                            fontFamily = cabin
                        )
                        Image(
                            painter = footballimg,
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                                .padding(bottom = 7.dp)
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .size(width = 340.dp, height = 90.dp)
                    .background(color = Color(0xFF75FF68), shape = RoundedCornerShape(16.dp))
                    .clickable {
                        navController.navigate(MatchAppScreen.Basketball.name)
                    }
            ) {
                Column(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Basketball",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(5.dp),
                        fontFamily = boldcabin
                    )
                    Row {
                        Text(
                            text = stringResource(R.string.footballdesc),
                            modifier = Modifier
                                .size(height = 200.dp, width = 250.dp)
                                .padding(4.dp),
                            fontSize = 12.sp,
                            textAlign = TextAlign.Left,
                            fontFamily = cabin
                        )
                        Image(
                            painter = basketballimg,
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                                .padding(bottom = 7.dp)
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .size(width = 340.dp, height = 90.dp)
                    .background(color = Color(0xFF75FF68), shape = RoundedCornerShape(16.dp))
                    .clickable {
                        navController.navigate(MatchAppScreen.Volleyball.name)
                    }
            ) {
                Column(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Volleyball",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(5.dp),
                        fontFamily = boldcabin
                    )
                    Row {
                        Text(
                            text = stringResource(R.string.footballdesc),
                            modifier = Modifier
                                .size(height = 200.dp, width = 250.dp)
                                .padding(4.dp),
                            fontSize = 12.sp,
                            textAlign = TextAlign.Left,
                            fontFamily = cabin
                        )
                        Image(
                            painter = volleyballimg,
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                                .padding(bottom = 7.dp)
                        )
                    }
                }
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview2() {
    MatchBookTheme() {
        val navController = rememberNavController() // Create a NavController instance

        MatchBookTheme() {
            HomePagee(navController = navController)
        }
    }
}


