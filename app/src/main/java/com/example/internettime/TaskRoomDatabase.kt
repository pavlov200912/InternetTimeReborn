package com.example.internettime

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Task::class], version = 1)
public abstract class TaskRoomDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    companion object {
        @Volatile
        private var INSTANCE: TaskRoomDatabase? = null

        fun getDatabase(context: Context): TaskRoomDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskRoomDatabase::class.java,
                    "Task_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}