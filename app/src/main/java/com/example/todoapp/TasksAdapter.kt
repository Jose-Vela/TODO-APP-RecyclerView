package com.example.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TasksAdapter(private val tasks: List<Task>, private val onTaskSelected: (Int) -> Unit) : // onTaskSelected: (int) -> Unit, es una función lambda
    RecyclerView.Adapter<TasksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        /*Este metodo crea una vista para "montarla" en pantalla, para que posteriormente el método
        onBindViewHolder() pueda pasarle la información que tiene que "pintar".*/
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TasksViewHolder(view)
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.render(tasks[position])
        holder.itemView.setOnClickListener { onTaskSelected(position) }
    }
}