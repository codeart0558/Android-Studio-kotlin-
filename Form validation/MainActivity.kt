package com.example.formvalidation

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uname = findViewById<EditText>(R.id.username)
        val pass = findViewById<EditText>(R.id.password)
        val conpass = findViewById<EditText>(R.id.conpassword)
        val mail = findViewById<EditText>(R.id.email)
        val phonenumber = findViewById<EditText>(R.id.phonenumber)
        val age = findViewById<EditText>(R.id.age)
        val genderGroup = findViewById<RadioGroup>(R.id.radiogroup)
        val btn = findViewById<Button>(R.id.submit)

        btn.setOnClickListener {

            val username = uname.text.toString().trim()
            val password = pass.text.toString()
            val confirmPassword = conpass.text.toString()
            val email = mail.text.toString().trim()
            val phone = phonenumber.text.toString().trim()
            val userAge = age.text.toString().trim()
            val selectedGenderId = genderGroup.checkedRadioButtonId

            // 🧪 Validation
            when {
              username.isEmpty() -> {
                  uname.error = "this filed is required"
                  uname.requestFocus()
              }

                password.isEmpty() -> {
                    pass.error = "Password is required"
                    pass.requestFocus   ()
                }

                confirmPassword.isEmpty() -> {
                    conpass.error = "Please confirm your password"
                    conpass.requestFocus()
                }

                password != confirmPassword -> {
                    conpass.error = "Passwords do not match"
                    conpass.requestFocus()
                }


                email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    mail.error = "this filed is reuiqred"
                    mail.requestFocus()
                }

                phone.isEmpty() || phone.length < 10 -> {
                    phonenumber.error = "Phone number must be at least 10 digits"
                    phonenumber.requestFocus()
                }

                userAge.isEmpty() -> {
                    age.error = "Age is required"
                    age.requestFocus()
                }

                // ✅ Age validation (must be between 1 and 120)
                userAge.toIntOrNull() == null || userAge.toInt() !in 1..120-> {
                    age.error = "Enter a valid age between 1 and 120"
                    age.requestFocus()
                }

                selectedGenderId == -1 -> {
                    Toast.makeText(this, "Please select a gender", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    val selectedGender = findViewById<RadioButton>(selectedGenderId).text.toString()

                    val message = """
                        ✅ Form Submitted:
                        Username: $username
                        Email: $email
                        Phone: $phone
                        Age: $userAge
                        Gender: $selectedGender
                    """.trimIndent()

                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
