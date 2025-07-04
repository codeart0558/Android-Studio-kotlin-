package com.example.inapp

import android.os.Bundle
import android.os.Environment
import android.util.Log
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
        val txtmsg = findViewById<TextView>(R.id.txtMsg)

        val writeButton =
            findViewById<Button>(R.id.btnWrite)
        val readButton =
            findViewById<Button>(R.id.btnRead)
        val myFile =
            File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "MyFile1.txt")
            writeButton.setOnClickListener() {
            myFile.writeText("From my file to inApp documents")
                    txtmsg.text = "Data written sucessfully!!"
        }
        readButton.setOnClickListener() {
            val contentsOfFile = myFile.readText()
            txtmsg.text = contentsOfFile
            Log.d("MyData", contentsOfFile)
        }
// List of all files
        val files = filesDir.listFiles()
        files?.forEach { file ->
            Log.d("FileList", "File: ${file.name}")
        }
// to delete your file
        val fileToDelete = File(filesDir, "MyFile1.txt")
        if (fileToDelete.exists()) {
            fileToDelete.delete()
        }
    }
}
