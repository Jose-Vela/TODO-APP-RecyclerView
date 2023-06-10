package com.example.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.TaskCategory.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val categories = listOf(
        Business,
        Personal,
        Other
    )

    private val tasks = mutableListOf(
        Task("PruebaBusiness", Business),
        Task("PruebaPersonal", Personal),
        Task("PruebaOther", Other)
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter

    private lateinit var fabAddTask: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_new_task)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val edTask: EditText = dialog.findViewById(R.id.edTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = edTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.todo_dialog_category_business) -> Business
                    getString(R.string.todo_dialog_category_personal) -> Personal
                    else -> Other
                }

                tasks.add(Task(currentTask, currentCategory))
                updateTasks()
                dialog.hide()
            }
        }

        dialog.show()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories) { position -> updateCategories(position) }
        rvCategories.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )   // Define la orientación del RecyclerView
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks) { position -> onItemSelected(position) }     // { position -> onItemSelected(position) }, Indica que es una funcion Lambda
        rvTasks.layoutManager =
            LinearLayoutManager(this)    // Si lo queremos en VERTICAL, no es necesario colocarlo, ya que es el valor por defecto
        rvTasks.adapter = tasksAdapter
    }

    private fun onItemSelected(position:Int){
        tasks[position].isSelected = !tasks[position].isSelected
        tasksAdapter.notifyItemChanged(position)
    }

    private fun updateCategories(position: Int){
        //categories[position].isSelected = !categories[position].isSelected
        //categoriesAdapter.notifyItemChanged(position)
    }

    private fun updateTasks() {
        tasksAdapter.notifyDataSetChanged()
    }
}