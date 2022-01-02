package fr.epsi.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.android.CategoryAdapter.ViewHolder

class CategoryAdapter(val category: ArrayList<Category>):RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val textViewTitle = view.findViewById<TextView>(R.id.textViewTitle)
        val contentLayout = view.findViewById<LinearLayout>(R.id.contentLayout2)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_categories, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = category.get(position)
        holder.textViewTitle.text=category.title
    }

    override fun getItemCount(): Int {
        return category.size
    }
}
