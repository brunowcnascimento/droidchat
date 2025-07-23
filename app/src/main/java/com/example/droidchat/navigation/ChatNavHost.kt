package com.example.droidchat.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

const val SPLASH_ROUTE = "splash"
const val SIGN_IN_ROUTE = "signIn"
const val SIGN_UP_ROUTE = "signUp"

@Composable
fun ChatNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "") {
        composable(SPLASH_ROUTE) {

        }
        composable(SIGN_IN_ROUTE) {

        }
        composable(SIGN_UP_ROUTE) {

        }
    }
}