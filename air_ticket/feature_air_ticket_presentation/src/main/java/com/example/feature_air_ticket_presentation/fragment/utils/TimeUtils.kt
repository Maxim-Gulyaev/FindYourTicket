package com.example.feature_air_ticket_presentation.fragment.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import kotlin.math.roundToInt

fun String.formatTime(): String? {
    val inputFormat: DateFormat =
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val date: Date? = inputFormat.parse(this)
    val outputFormat: DateFormat =
        SimpleDateFormat("HH:mm", Locale.getDefault())
    return date?.let { outputFormat.format(it) }
}

fun calculateTravelTime(
    departureDate: String,
    arrivalDate: String
): String {
    val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
    val departureDateTime = LocalDateTime.parse(departureDate, formatter)
    val arrivalDateTime = LocalDateTime.parse(arrivalDate, formatter)
    val travelTime = Duration.between(departureDateTime, arrivalDateTime)

    val hours = travelTime.toHours().toDouble()
    return (((hours * 2).roundToInt() / 2.0).toString()) + " часа в пути"
}

fun getFormattedDate(
    date: Long,
    format: String
): String =
    SimpleDateFormat(
        format,
        Locale(Constants.RU_LANGUAGE, Constants.RU_COUNTRY)
    )
        .format(Date(date))
        .replace(".", Constants.EMPTY_STRING)
