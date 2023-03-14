package com.example.weathercomposeapp.utils

import java.util.*

private fun createListOfDateElements(dateMilsec: Int) : List<String> {
    val date = Date((dateMilsec * 1000).toLong()).toString()
    return date.split(" ")
}

fun createDateString(dateMilsec: Int): String {
    val splitDate = createListOfDateElements(dateMilsec)
    return "${splitDate[0]}, ${splitDate[1]} ${splitDate[2]}"
}

fun getDayOfWeek(dateMilsec: Int): String {
    val splitDate = createListOfDateElements(dateMilsec)
    return "${splitDate[0]}"
}

fun createTimeString(dateMilsec: Int): String {
    val splitDate = createListOfDateElements(dateMilsec)
    val splitTime = splitDate[3].split(":")
    return "${splitTime[0]}:${splitTime[1]}:AM"
}