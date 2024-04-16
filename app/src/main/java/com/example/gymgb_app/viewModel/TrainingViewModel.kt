package com.example.gymgb_app.viewModel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gymgb_app.model.Training
import com.example.gymgb_app.model.JsonManager

class TrainingViewModel(application: Application) : ViewModel() {
    private val appContext: Context = application.applicationContext

    private val _trainging = MutableLiveData<List<Training>>()
    val currentTraining: LiveData<List<Training>> = _trainging



    fun getTraining(nameTraining:String) {
        val selectedTraining = JsonManager.getTrainingByName(appContext, nameTraining)
        _trainging.value = selectedTraining
    }

}