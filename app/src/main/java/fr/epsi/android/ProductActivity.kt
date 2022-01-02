package fr.epsi.android

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProductActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zone2)
        setHeaderTitle("Rayons")
        showBack()
        val categories = arrayListOf<Category>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCategories)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val categoriesAdapter = CategoryAdapter(categories)
        recyclerView.adapter=categoriesAdapter
        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL="https://djemam.com/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }


            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()

                if(data!=null){
                    val jsCategories = JSONObject(data)
                    val jsArrayStudents= jsCategories.getJSONArray("items")
                    for(i in 0 until jsArrayStudents.length()){
                        val jsCategory = jsArrayStudents.getJSONObject(i)
                        val categorie = Category(jsCategory.optString("category_id",""),jsCategory.optString("title", ""),jsCategory.optString("products_url", ""))
                        categories.add(categorie)
                        Log.d("Categorie ",categorie.title)
                    }
                }
                Log.d("Categorie","${categories.size}")

                runOnUiThread(Runnable {
                    categoriesAdapter.notifyDataSetChanged()
                })
            }
        })
    }
}