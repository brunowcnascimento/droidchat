package com.example.droidchat.ui.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.droidchat.R

@Composable
fun SplashRoute() {

}

@Composable
fun SplashScreen() {
    Column {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null
        )

        Row {

        }
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen()
}

