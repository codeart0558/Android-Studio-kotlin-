package com.example.file_storage

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val dir = File(getFilesDir(), "myDirectory")
        if (!dir.exists()) {
            dir.mkdirs()
        }
        val file = File(dir, "nestedFile.txt")
        val btn = findViewById<Button>(R.id.btnSave)
        val msg = findViewById<TextView>(R.id.txtMsg)
        val path = findViewById<TextView>(R.id.txtPath)
        btn.setOnClickListener(){
            file.writeText("This is inside a directory.")
            msg.text = "File created"
            path.text = "$dir.path ${dir.name}" 
        }
    }
}
