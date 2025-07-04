package com.example.crudexample

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var db: DatabaseHelper
    lateinit var editName: EditText
    lateinit var editEmail: EditText
    lateinit var editId: EditText
    lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DatabaseHelper(this)

        editName = findViewById(R.id.editName)
        editEmail = findViewById(R.id.editEmail)
        editId = findViewById(R.id.editId)
        resultText = findViewById(R.id.textResult)

        findViewById<Button>(R.id.btnInsert).setOnClickListener {

            val name = editName.text.toString()
            val email = editEmail.text.toString()

            if (db.insertUser(name, email)) {
                Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show()
                clearFields()
            } else {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btnView).setOnClickListener {
            val users = db.getAllUsers()
            val displayText = users.joinToString("\n") { "ID: ${it.id}, Name: ${it.name}, Email: ${it.email}" }
                        resultText.text = displayText
        }

        findViewById<Button>(R.id.btnUpdate).setOnClickListener {
            val id = editId.text.toString().toIntOrNull()
            val name = editName.text.toString()
            val email = editEmail.text.toString()
            if (id != null && db.updateUser(id, name, email)) {
                Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show()
                clearFields()
            } else {
                Toast.makeText(this, "Failed to Update", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btnDelete).setOnClickListener {
            val id = editId.text.toString().toIntOrNull()
            if (id != null && db.deleteUser(id)) {
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
                clearFields()
            } else {
                Toast.makeText(this, "Failed to Delete", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clearFields() {
        editName.text.clear()
        editEmail.text.clear()
        editId.text.clear()
    }
}
