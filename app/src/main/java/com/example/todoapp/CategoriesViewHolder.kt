package com.example.todoapp

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CategoriesViewHolder(view: View):  RecyclerView.ViewHolder(view){
    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)

    fun render(taskCategory: TaskCategory){
        when(taskCategory){
            TaskCategory.Business -> {
                tvCategoryName.text = tvCategoryName.context.getString(R.string.todo_dialog_category_business)
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.todo_business_category))
            }
            TaskCategory.Other -> {
                tvCategoryName.text = tvCategoryName.context.getString(R.string.todo_dialog_category_other)
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.todo_other_category))
            }
            TaskCategory.Personal -> {
                tvCategoryName.text = tvCategoryName.context.getString(R.string.todo_dialog_category_personal)
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.todo_personal_category))
            }
        }
    }
}