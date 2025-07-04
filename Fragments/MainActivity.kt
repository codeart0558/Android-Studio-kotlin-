package com.example.fregment

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnA = findViewById<Button>(R.id.btn1)
        val btnB = findViewById<Button>(R.id.btn2)

        btnA.setOnClickListener {
            val message = "Hello from MainActivity"
            val fragment = FragmentA.newInstance(message)
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment).commit()
        }

        btnB.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, FragmentB()).commit()
        }
    }
}