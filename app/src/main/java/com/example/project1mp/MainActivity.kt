package com.example.project1mp // Sesuai namespace proyek "Project 1 MP"

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvTitle: TextView
    private lateinit var btnStart: Button
    private lateinit var btnToggle: Button
    private lateinit var btnOpenPractice: Button
    private var isHello = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Merujuk ke activity_main.xml

        // Inisialisasi Views
        tvTitle = findViewById(R.id.tvTitle) // Pastikan ID ini ada di activity_main.xml
        btnStart = findViewById(R.id.btnStart) // Pastikan ID ini ada di activity_main.xml
        btnToggle = findViewById(R.id.btnToggle) // Pastikan ID ini ada di activity_main.xml
        btnOpenPractice = findViewById(R.id.btnOpenPractice) // Pastikan ID ini ada di activity_main.xml

        // Atur visibilitas awal tombol
        btnToggle.visibility = View.GONE
        btnOpenPractice.visibility = View.GONE

        // Event listener untuk tombol Start
        btnStart.setOnClickListener {
            tvTitle.text = "Aplikasi Dimulai 🚀"
            isHello = false // Perbaikan: Set state agar toggle logic benar setelah start
            btnStart.visibility = View.GONE
            btnToggle.visibility = View.VISIBLE
            btnOpenPractice.visibility = View.VISIBLE
        }

        // Event listener untuk tombol Toggle Pesan
        btnToggle.setOnClickListener {
            if (isHello) {
                tvTitle.text = "Selamat Datang di Mobile Programming 👋"
                btnToggle.text = "Kembalikan Pesan"
            } else {
                tvTitle.text = "Aplikasi Dimulai 🚀" // Perbaikan: Hilangkan spasi ekstra
                btnToggle.text = "Toggle Pesan"
            }
            isHello = !isHello
        }

        // Event listener untuk tombol Buka Latihan Layout
        btnOpenPractice.setOnClickListener {
            // Pastikan LayoutPracticeActivity ada dan dideklarasikan di AndroidManifest.xml
            val intent = Intent(this, LayoutPracticeActivity::class.java)
            startActivity(intent)
        }
    }
}
