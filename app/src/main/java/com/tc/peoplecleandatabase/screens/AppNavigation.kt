package com.tc.peoplecleandatabase.screens

import android.annotation.SuppressLint
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val targetScreen = rememberSaveable { mutableStateOf(Screens.PeopleList) }

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = targetScreen.value.header, color = Color.White
            )
        }, navigationIcon = {
            if (targetScreen.value.route == Screens.PeopleDetails.route) {
                BackButton(navController = navController)
            }
        }, colors = TopAppBarDefaults.smallTopAppBarColors(Color(0xFF6F7FF7)))
    }) {
        NavHost(
            navController = navController, startDestination = Screens.PeopleList.route
        ) {
            composable(Screens.PeopleList.route) {
                targetScreen.value = Screens.PeopleList
                PeopleScreen(navController)
            }
            composable("${Screens.PeopleDetails.route}/{id}") { backStackEntry ->
                targetScreen.value = Screens.PeopleDetails
                PeopleDetails(
                    backStackEntry.arguments?.getString("id")!!.toLong()
                )
            }
        }
    }
}

@Composable
fun BackButton(navController: NavController) {
    IconButton(onClick = { navController.popBackStack() }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.White
        )
    }
}

