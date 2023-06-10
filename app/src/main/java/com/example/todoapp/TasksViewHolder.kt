package com.example.todoapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvTask: TextView = view.findViewById(R.id.tvTask)
    private val cbTask: CheckBox = view.findViewById(R.id.cbTask)

    fun render(task: Task, onTaskSelected: (Int) -> Unit) {

        tvTask.text = task.name
        cbTask.isChecked = task.isSelected

        cbTask.setOnClickListener { onTaskSelected(layoutPosition) }

        itemView.setOnClickListener { onTaskSelected(layoutPosition) }


        if (task.isSelected) {
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }


        val color = when (task.category) {
            TaskCategory.Business -> R.color.todo_business_category

            TaskCategory.Other -> R.color.todo_other_category

            TaskCategory.Personal -> R.color.todo_personal_category
        }

        cbTask.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(cbTask.context, color))
    }

}