package com.example.internettime

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface TaskDao{
    @Query("SELECT * from task_table ORDER BY name ASC")
    fun getAllTasks(): LiveData<List<Task>> // TODO How to use this LiveData?

    @Insert
    fun insert(task: Task)

    @Query("DELETE FROM task_table")
    fun deleteAll()
}