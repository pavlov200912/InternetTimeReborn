package com.example.internettime

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TaskListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var tasks = emptyList<Task>() // Cached copy of words

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val current = tasks[position]
        holder.taskItemView.text = current.name
    }

    internal fun setWords(tasks: List<Task>) {
        this.tasks = tasks
        notifyDataSetChanged()
    }

    override fun getItemCount() = tasks.size
}