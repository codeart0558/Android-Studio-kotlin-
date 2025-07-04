package com.example.crudexample

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "UserDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = """
            CREATE TABLE Users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                email TEXT
            )
        """.trimIndent()
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS Users")
        onCreate(db)
    }

    fun insertUser(name: String, email: String): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put("name", name)
        values.put("email", email)

        val result = db.insert("Users", null, values)
        return result != -1L
    }

    fun getAllUsers(): List<User> {
        val list = mutableListOf<User>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM Users", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val email = cursor.getString(2)
                list.add(User(id, name, email))
            } while (cursor.moveToNext())
        }

        cursor.close()
        return list
    }

    fun updateUser(id: Int, name: String, email: String): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put("name", name)
        values.put("email", email)

        val result = db.update("Users", values, "id=?", arrayOf(id.toString()))
        return result > 0
    }

    fun deleteUser(id: Int): Boolean {
        val db = writableDatabase
        val result = db.delete("Users", "id=?", arrayOf(id.toString()))
        return result > 0
    }
}
