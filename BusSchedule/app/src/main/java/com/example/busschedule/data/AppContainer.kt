package com.example.busschedule.data

import android.content.Context

interface AppContainer {
    val busScheduleDao: BusScheduleDao
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val busScheduleDao: BusScheduleDao by lazy {
        BusScheduleDatabase.getDatabase(context).busScheduleDao()
    }
}