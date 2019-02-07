package com.example.internettime

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: LiveData<List<Task>> = taskDao.getAllTasks()

    @WorkerThread
    suspend fun insert(task: Task) {
        taskDao.insert(task)
    }
}