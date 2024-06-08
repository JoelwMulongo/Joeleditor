// src/main/java/com/example/joeleditor/MainActivity.kt
package com.example.joeleditor

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var editor: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editor = findViewById(R.id.editor)

        val saveButton: Button = findViewById(R.id.save_button)
        saveButton.setOnClickListener { saveFile() }

        val openButton: Button = findViewById(R.id.open_button)
        openButton.setOnClickListener { openFile() }

        val runButton: Button = findViewById(R.id.run_button)
        runButton.setOnClickListener { runCode() }
    }

    private fun saveFile() {
        val code = editor.text.toString()
        try {
            val fos: FileOutputStream = openFileOutput("code.txt", MODE_PRIVATE)
            fos.write(code.toByteArray())
            fos.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun openFile() {
        try {
            val fis: FileInputStream = openFileInput("code.txt")
            val buffer = ByteArray(fis.available())
            fis.read(buffer)
            fis.close()
            editor.setText(String(buffer))
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun runCode() {
        // Implement code execution logic here
    }
}
