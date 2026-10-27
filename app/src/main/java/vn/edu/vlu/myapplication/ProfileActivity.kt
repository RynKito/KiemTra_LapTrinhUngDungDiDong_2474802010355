package vn.edu.vlu.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        val lvSubjects = findViewById<ListView>(R.id.lvSubjects)

        val email = intent.getStringExtra("EMAIL")
        tvEmail.text = "Email: $email"

        btnLogout.setOnClickListener {
            finish()
        }

        val subjects = listOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android",
            "Cơ sở dữ liệu SQLite"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjects)
        lvSubjects.adapter = adapter

        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, subjects[position], Toast.LENGTH_SHORT).show()
        }
    }
}