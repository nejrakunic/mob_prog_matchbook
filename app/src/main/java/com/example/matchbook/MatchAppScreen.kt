package com.example.matchbook

import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.matchbook.data.AppDatabase
import com.example.matchbook.pages.BasketballPage
import com.example.matchbook.pages.FootballPage
import com.example.matchbook.pages.HomePagee
import com.example.matchbook.pages.LogInPage
import com.example.matchbook.pages.Registration
import com.example.matchbook.pages.StartPage
import com.example.matchbook.pages.VolleyballPage

enum class MatchAppScreen(@StringRes val title:Int){
    StartPage(title= R.string.start_page),
    Registration(title=R.string.registration),
    Login(title= R.string.login),
    HomePage(title=R.string.home),
    Football(title= R.string.football),
    Basketball(title= R.string.basketball),
    Volleyball(title=R.string.volleyball)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchBookAppTopBar(
    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier){
    TopAppBar(
        title= {Text(stringResource(currentScreenTitle))},
        modifier=modifier,
        navigationIcon= {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        },
        colors= TopAppBarDefaults.topAppBarColors(
            containerColor= Color(0xFF006E0A)
        )


    )

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MatchBookApp(
    context: Context
){

    val database= AppDatabase.getDatabase(context)
    val navController= rememberNavController()
    val backStackEntry by
    navController.currentBackStackEntryAsState()
    val currentScreen=MatchAppScreen.valueOf(
        backStackEntry?.destination?.route?:
        MatchAppScreen.StartPage.name
    )
    Scaffold(
        topBar = {
            MatchBookAppTopBar(
                currentScreenTitle = currentScreen.title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },
        content = {
            NavHost(
                navController = navController,
                startDestination = MatchAppScreen.StartPage.name,
            ) {
                composable(route = MatchAppScreen.StartPage.name) {
                    StartPage(
                        onRegistrationClicked = {
                            navController.navigate(MatchAppScreen.Registration.name)
                        },
                        onLoginClicked = {
                            navController.navigate(MatchAppScreen.Login.name)
                        }
                    )
                }
                composable(route = MatchAppScreen.Registration.name) {
                    Registration(
                        onCancelClicked = {
                            navController.navigate(MatchAppScreen.StartPage.name)
                        },
                        navController = navController,
                        database = database

                    )
                }

                composable(route = MatchAppScreen.Login.name) {
                    LogInPage(
                        onCancelClicked = {
                            navController.navigate(MatchAppScreen.StartPage.name)
                        },
                        navController = navController,
                        database = database,
                    )
                }
                composable(route = MatchAppScreen.HomePage.name) {
                    HomePagee(
                        navController=navController

                    )
                }
                composable(route = MatchAppScreen.Football.name) {
                    FootballPage(
                        onCancelClick = {
                            navController.navigate(MatchAppScreen.HomePage.name)
                        }
                    )
                }
                composable(route = MatchAppScreen.Basketball.name) {
                    BasketballPage(
                        onCancelClick = {
                            navController.navigate(MatchAppScreen.HomePage.name)
                        }
                    )
                }
                composable(route = MatchAppScreen.Volleyball.name) {
                    VolleyballPage(
                        onCancelClick = {
                            navController.navigate(MatchAppScreen.HomePage.name)
                        }
                    )
                }
            }
        }
    )
}

