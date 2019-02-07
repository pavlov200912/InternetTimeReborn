package com.example.internettime

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    private val repository: TaskRepository
    val allWords: LiveData<List<Task>>

    init {
        val tasksDao = TaskRoomDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(tasksDao)
        allWords = repository.allTasks
    }

    fun insert(task: Task) = scope.launch(Dispatchers.IO) {
        repository.insert(task)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}