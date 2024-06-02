package com.example.matchbook.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
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
import com.example.matchbook.MatchAppScreen
import com.example.matchbook.R
import com.example.matchbook.ui.theme.MatchBookTheme

@Composable
fun BasketballPage(
    onCancelClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val cabin = FontFamily(Font(R.font.cabin))
    val boldcabin = FontFamily(Font(R.font.cabin_bold))
    val bulls = painterResource(R.drawable.bulls)
    val lakers = painterResource(R.drawable.lakers)
    val cleveland = painterResource(R.drawable.cleveland)
    val golden = painterResource(R.drawable.golden)
    val knicks = painterResource(R.drawable.knicks)
    val pistons = painterResource(R.drawable.pistons)




    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 16.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Matches",
                fontSize = 30.sp,
                modifier = modifier.padding(top = 90.dp),
                fontFamily = boldcabin
            )

            Box(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .size(width = 340.dp, height = 90.dp)
                    .background(color = Color(0xFF73796E), shape = RoundedCornerShape(16.dp))


            ) {
                Column(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(R.string.lakers),
                            modifier = Modifier
                                .size(height = 200.dp, width = 80.dp)
                                .padding(10.dp),
                            fontSize = 12.sp,
                            textAlign = TextAlign.Left,
                            fontFamily = cabin,
                            color= Color.White
                        )
                        Spacer(modifier = Modifier.width(100.dp))
                        Image(
                            painter = bulls,
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                                .padding(top = 30.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Image(
                            painter = lakers,
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                                .padding(top = 30.dp)
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .size(width = 340.dp, height = 90.dp)
                    .background(color = Color(0xFF73796E), shape = RoundedCornerShape(16.dp))


            ) {
                Column(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(R.string.cleveland),
                            modifier = Modifier
                                .size(height = 200.dp, width = 100.dp)
                                .padding(10.dp),
                            fontSize = 12.sp,
                            textAlign = TextAlign.Left,
                            fontFamily = cabin,
                            color= Color.White
                        )
                        Spacer(modifier = Modifier.width(80.dp))
                        Image(
                            painter = cleveland,
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                                .padding(top = 30.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Image(
                            painter = golden,
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                                .padding(top = 30.dp)
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .size(width = 340.dp, height = 90.dp)
                    .background(color = Color(0xFF73796E), shape = RoundedCornerShape(16.dp))


            ) {
                Column(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(R.string.knicks),
                            modifier = Modifier
                                .size(height = 200.dp, width = 80.dp)
                                .padding(10.dp),
                            fontSize = 12.sp,
                            textAlign = TextAlign.Left,
                            fontFamily = cabin,
                            color= Color.White
                        )
                        Spacer(modifier = Modifier.width(100.dp))
                        Image(
                            painter = knicks,
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                                .padding(top = 30.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Image(
                            painter = pistons,
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                                .padding(top = 30.dp)
                        )
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Preview7() {
    MatchBookTheme {
        BasketballPage({})
    }
}