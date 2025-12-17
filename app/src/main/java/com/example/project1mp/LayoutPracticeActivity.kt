package com.example.project1mp // PASTIKAN SESUAI NAMESPACE ANDA

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LayoutPracticeActivity : AppCompatActivity() {

    private lateinit var tvGreeting: TextView
    private lateinit var btnCreativeClick: Button
    private lateinit var tilName: TextInputLayout
    private lateinit var etName: TextInputEditText
    private lateinit var btnSubmitName: Button

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_practice)

        tvGreeting = findViewById(R.id.tvGreeting)
        btnCreativeClick = findViewById(R.id.btnCreativeClick)
        tilName = findViewById(R.id.tilName)
        etName = findViewById(R.id.etName)
        btnSubmitName = findViewById(R.id.btnSubmitName)

        btnCreativeClick.setOnClickListener {
            Toast.makeText(this, "Tombol Kreatif Ditekan!", Toast.LENGTH_SHORT).show()
            // Anda bisa menambahkan aksi lain di sini, misalnya mengubah teks greeting
            tvGreeting.text = "Kamu Mengklik Saya! ✨"
            // Tampilkan tombol submit nama setelah tombol kreatif ditekan
            btnSubmitName.visibility = View.VISIBLE
        }

        etName.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                greetUser()
                true // Menandakan event sudah di-handle
            } else {
                false
            }
        }

        btnSubmitName.setOnClickListener {
            greetUser()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun greetUser() {
        val name = etName.text.toString().trim()
        if (name.isNotEmpty()) {
            tvGreeting.text = "Hallo, $name! 👋"
            Toast.makeText(this, "Selamat Datang, $name!", Toast.LENGTH_LONG).show()
            etName.text = null // Kosongkan input setelah submit
            tilName.error = null // Hapus error jika ada
        } else {
            // Tampilkan pesan error di TextInputLayout jika nama kosong
            tilName.error = "Nama tidak boleh kosong"
            // Atau gunakan Toast jika tidak ingin error di TextInputLayout
            // Toast.makeText(this, "Masukkan nama Anda terlebih dahulu", Toast.LENGTH_SHORT).show()
        }
    }
}
