package com.example.feature_air_ticket_presentation.fragment.utils

fun Int.formatPrice(): String {
    val formattedValue = String.format("%,d", this).replace(',', ' ')
    return "от $formattedValue"
}