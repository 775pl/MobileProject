package fr.epsi.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonZone1 = findViewById<Button>(R.id.button_main_zone1)
        val buttonZone2 = findViewById<Button>(R.id.button_main_zone2)

        buttonZone1.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,Zone1Activity::class.java)
            startActivity(newIntent)
        })
        buttonZone2.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,Zone2Activity::class.java)
            startActivity(newIntent)
        })

    }
}