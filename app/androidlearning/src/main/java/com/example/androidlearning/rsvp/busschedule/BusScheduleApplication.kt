package com.example.androidlearning.rsvp.busschedule

import android.app.Application
import com.example.androidlearning.rsvp.busschedule.database.AppDatabase

class BusScheduleApplication : Application() {
        val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}