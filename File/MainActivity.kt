package com.example.file2

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val fileName = "ex1.txt"
        val fileContents = "Hello, drashti!"

        val btnWrite = findViewById<Button>(R.id.Write)
        val btnRead = findViewById<Button>(R.id.Read)
        val msg = findViewById<TextView>(R.id.txtMsg)

        btnWrite.setOnClickListener() {
            openFileOutput(fileName,Context.MODE_PRIVATE).use {
                it.write(fileContents.toByteArray())
            }
            msg.text = "Data Written successfully!!"
        }

        btnRead.setOnClickListener() {
            val fileInputStream = openFileInput(fileName)
            val content =
                fileInputStream.bufferedReader().use { it.readText() }
            msg.text = content
// Log.d("InternalRead", content)
        }
    }
}
