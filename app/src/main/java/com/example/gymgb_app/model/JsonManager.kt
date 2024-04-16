package com.example.gymgb_app.model

import android.content.Context
import android.util.Log
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileOutputStream

object JsonManager {
    private const val DIRECTORY_NAME = "training"
    private const val JSON_EXTENSION = ".json"


        fun saveTraining(context: Context, trainingToSave: Training, fileName: String) {
            val jsonString = Json.encodeToString(trainingToSave)
            val directory = File(context.getExternalFilesDir(null), DIRECTORY_NAME)
            directory.mkdirs()
            val file = File(directory, fileName + JSON_EXTENSION)

            try {
                val fileOutputStream = FileOutputStream(file)
                fileOutputStream.write(jsonString.toByteArray())
                fileOutputStream.close()
                Log.d("JSON_SAVE", "Recipe saved successfully to $file")
            } catch (e: Exception) {
                Log.e("JSON_SAVE", "Error saving recipe: ${e.message}")
            }
        }

        fun getTrainingByName(context: Context, fileName: String): Training {
            val directory = File(context.getExternalFilesDir(null), DIRECTORY_NAME)

            val jsonContent = File(directory, fileName + JSON_EXTENSION).readText()
            val readTraining = Json.decodeFromString<Training>(jsonContent)

            Log.d("READ_JSON", "Training name: ${readTraining.trainingName}")

            return readTraining
        }

    fun getTrainingSavedInDevice(context: Context, fileName: String): Training {
        val directory = File(context.getExternalFilesDir(null), DIRECTORY_NAME)

        val jsonContent = File(directory, fileName + JSON_EXTENSION).readText()
        val readTraining = Json.decodeFromString<Training>(jsonContent)

        Log.d("READ_JSON", "Training name: ${readTraining.trainingName}")

        return readTraining
    }

    fun getMealsList(context: Context): List<Training> {
        val directory = File(context.getExternalFilesDir(null), DIRECTORY_NAME)

        val mealsList = mutableListOf<Training>()
        Log.d("JSON_READ", "Total JSON: ${mealsList.count()}")

        directory.listFiles { file ->
            file.isFile && file.extension.equals("json", ignoreCase = true)
        }?.forEach { file ->
            try {
                val jsonContent = file.readText()
                val meal = Json.decodeFromString<Training>(jsonContent)
                mealsList.add(meal)
                Log.d("JSON_READ", "JSON READED: ${file.name}")
            } catch (e: Exception) {
                Log.d("JSON", "Error reading JSON file: ${file.name}, ${e.message}")
                println("Error reading JSON file: ${file.name}, ${e.message}")
            }
        }

        return mealsList
    }


}