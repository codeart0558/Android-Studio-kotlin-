package com.example.intent
//tanka tanka tere bas ka :  meri mannt tu tujko
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener{
            val unamw = username.text.toString().trim()
            val pass = password.text.toString().trim()

            if(unamw.isEmpty() && pass.isEmpty()){
                Toast.makeText(this,"fild cant be empty",Toast.LENGTH_SHORT).show()

            }
            else{

                Toast.makeText(this,"loggin  suces ful ", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,MainActivity2::class.java)
                intent.putExtra("username", unamw)
                startActivity(intent)

            }

        }
    }
}