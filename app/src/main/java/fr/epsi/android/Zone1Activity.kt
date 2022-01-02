package fr.epsi.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Zone1Activity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zone1)

        val buttonStudent1 = findViewById<Button>(R.id.button_student_1)
        val buttonStudent2 = findViewById<Button>(R.id.button_student_2)
        val buttonStudent3 = findViewById<Button>(R.id.button_student_3)

        buttonStudent1.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,Student1Activity::class.java)
            startActivity(newIntent)
        })
        buttonStudent2.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,Student2Activity::class.java)
            startActivity(newIntent)
        })
        buttonStudent3.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,Student3Activity::class.java)
            startActivity(newIntent)
        })
    }
}