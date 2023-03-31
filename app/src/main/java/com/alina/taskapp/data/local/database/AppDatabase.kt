package com.alina.taskapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alina.taskapp.model.Task


@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
