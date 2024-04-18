package com.example.feature_air_ticket_presentation.fragment.utils

import android.content.Context
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.EMPTY_STRING
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.INPUT_KEY
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.INPUT_STORAGE

class SharedPreferences(
    private val context: Context
) {
    fun saveInput(input: String) {
        context.getSharedPreferences(INPUT_STORAGE, Context.MODE_PRIVATE)
            .edit()
            .putString(INPUT_KEY, input)
            .apply()
    }

    fun getInput(): String = context.getSharedPreferences(INPUT_STORAGE, Context.MODE_PRIVATE)
            .getString(INPUT_KEY, EMPTY_STRING) ?: EMPTY_STRING
}