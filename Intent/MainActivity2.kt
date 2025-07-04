package com.example.intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
         val view = findViewById<TextView>(R.id.textView)
         val btn = findViewById<Button>(R.id.button)

        val msg = intent.getStringExtra("username")
        view.text="welcome $msg"

        // string :op  1 is add: android:text="@string/drashti"
        //op : 2 is below
        val view2 = findViewById<TextView>(R.id.textView2)
        val message=getString(R.string.drashti)
        view2.text=message



        btn.setOnClickListener{
            val intent2 = Intent(this,MainActivity::class.java)
            startActivity(intent2)
            finish()
        }

    }
}