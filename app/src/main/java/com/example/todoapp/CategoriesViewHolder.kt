package com.example.todoapp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)
    private val viewContainer: CardView = view.findViewById(R.id.viewContainer)

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {

        val categoryText: Int   // Lo inicializamos como tipo entero, ya que la función getString() recibe por parametro un Int, (R.string.my_string = Int)
        val categoryColor: Int  // Lo inicializamos como tipo entero, ya que la función getColor() recibe como segundo parametro un Int, que hace referencia a un color (R.color.my_color = Int)

        val cardBackgroundColor = if (taskCategory.isSelected) R.color.todo_background_card else R.color.todo_background_disabled
        viewContainer.setCardBackgroundColor(ContextCompat.getColor(viewContainer.context, cardBackgroundColor))

        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        when (taskCategory) {
            TaskCategory.Business -> {
                categoryText = R.string.todo_dialog_category_business
                categoryColor = R.color.todo_business_category
            }

            TaskCategory.Other -> {
                categoryText = R.string.todo_dialog_category_other
                categoryColor = R.color.todo_other_category
            }

            TaskCategory.Personal -> {
                categoryText = R.string.todo_dialog_category_personal
                categoryColor = R.color.todo_personal_category
            }
        }

        tvCategoryName.text = tvCategoryName.context.getString(categoryText)
        divider.setBackgroundColor(ContextCompat.getColor(divider.context, categoryColor))
    }
}