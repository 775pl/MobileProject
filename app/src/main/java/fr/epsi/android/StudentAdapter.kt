package fr.epsi.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.epsi.android.StudentAdapter.ViewHolder

class StudentAdapter(val students: ArrayList<Student>):RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val textViewName = view.findViewById<TextView>(R.id.textViewName)
        val textViewEmail = view.findViewById<TextView>(R.id.textViewEmail)
        val imageViewStudent = view.findViewById<ImageView>(R.id.imageViewStudent)
        val textViewSurname = view.findViewById<TextView>(R.id.textViewSurname)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_student, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students.get(position)
        holder.textViewName.text=student.name
        holder.textViewEmail.text=student.email
        holder.textViewSurname.text=student.surname
        Picasso.get().load(student.imgUrl).into(holder.imageViewStudent)
    }

    override fun getItemCount(): Int {
        return students.size
    }
}
