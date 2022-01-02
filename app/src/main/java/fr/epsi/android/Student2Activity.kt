package fr.epsi.android

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class Student2Activity : BaseActivity(){

    val data="{\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"picture_url\": \"https://img1.freepng.fr/20180626/ehy/kisspng-avatar-user-computer-icons-software-developer-5b327cc951ae22.8377289615300354013346.jpg\",\n" +
            "      \"name\": \"Allan\",\n" +
            "      \"surname\": \"Baroil\",\n" +
            "      \"email\": \"allan@epsi.fr\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://static.vecteezy.com/ti/vecteur-libre/p1/2779405-femme-avatar-portrait-d-une-jeune-femme-dans-un-style-retro-portrait-de-femme-minimaliste-plat-vector-illustration-vectoriel.jpg\",\n" +
            "      \"name\": \"Laïla\",\n" +
            "      \"surname\": \"Abbas\",\n" +
            "      \"email\": \"laila@epsi.fr\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://cdn.icon-icons.com/icons2/1736/PNG/512/4043260-avatar-male-man-portrait_113269.png\",\n" +
            "      \"name\": \"Nicolas\",\n" +
            "      \"surname\": \"Barrot\",\n" +
            "      \"email\": \"nicolas@epsi.fr\"\n" +
            "    },\n" +
            "  ]\n" +
            "}"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student2)

        setHeaderTitle("Students")
        showBack()
        val students = arrayListOf<Student>()
        val jsStudents = JSONObject(data)
        val jsArrayStudents= jsStudents.getJSONArray("items")

        val jsStudent = jsArrayStudents.getJSONObject(1)
        val student = Student(jsStudent.optString("name",""), jsStudent.optString("surname",""),jsStudent.optString("email",""),jsStudent.optString("picture_url",""))
        students.add(student)
        Log.d("student",student.name)

        Log.d("Student","${students.size}")

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewStudents)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val studentAdapter = StudentAdapter(students)
        recyclerView.adapter=studentAdapter

    }
}