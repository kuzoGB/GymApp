package com.example.gymgb_app.navigator

sealed class AppScreens(val route: String) {

    object MenuScreen : AppScreens("menu_screen")
    object NewTrainingScreen : AppScreens("new_training_screen")

}