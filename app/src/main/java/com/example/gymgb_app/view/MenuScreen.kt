package com.example.gymgb_app.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.gymgb_app.navigator.AppScreens

@Composable
fun MenuScreen(
    navController: NavController
){

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = { navController.navigate(AppScreens.MenuScreen.route) }) {
            Text(text = "Start training")
        }
        Button(onClick = { navController.navigate(AppScreens.NewTrainingScreen.route) }) {
            Text(text = "Create/edit training routine")
        }
    }

}