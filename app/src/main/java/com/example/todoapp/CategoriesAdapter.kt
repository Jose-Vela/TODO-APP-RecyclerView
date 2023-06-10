package com.example.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(
    private val categories: List<TaskCategory>, private val onItemSelected: (Int) -> Unit) :
    RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        /*Este metodo crea una vista para "montarla" en pantalla, para que posteriormente el método
        onBindViewHolder() pueda pasarle la información que tiene que "pintar".*/
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun getItemCount() = categories.size   // Este metodo retorna el tamaño del listado de las categorías

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        /* En este caso enviamos la función Lambda por parametro a la función render().
         OJO: Se envia la función onItemSelected sin los parentesis (),
         ya que de esta manera solo se envía, si colocamos los parentesis, es decir; onItemSelected(),
         esta se ejecutaría   */
        holder.render(categories[position], onItemSelected)
    }
}