package fr.epsi.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.epsi.android.ProductAdapter.ViewHolder

class ProductAdapter(val products: ArrayList<Product>):RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val textViewName = view.findViewById<TextView>(R.id.textViewName)
        val textViewDescription = view.findViewById<TextView>(R.id.textViewDescription)
        val imageViewProducts = view.findViewById<ImageView>(R.id.imageViewProducts)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_products, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)
        holder.textViewName.text=product.name
        holder.textViewDescription.text=product.description
        Picasso.get().load(product.picture_url).into(holder.imageViewProducts)
    }

    override fun getItemCount(): Int {
        return products.size
    }

}
