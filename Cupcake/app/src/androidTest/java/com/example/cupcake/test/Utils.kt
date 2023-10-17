package com.example.cupcake.test

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


fun getFormattedDate(): String {
    val calendar = Calendar.getInstance()
    calendar.add(java.util.Calendar.DATE, 1)
    val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
    return formatter.format(calendar.time)
}