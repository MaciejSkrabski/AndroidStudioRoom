package com.example.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.room.Room
import androidx.room.RoomDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            this, DanieDatabase::class.java,"meal_database"
        )
        var add = findViewById<Button>(R.id.buttonAdd)
        add.setOnClickListener { Toast.makeText(this, "Guzik!", Toast.LENGTH_SHORT).show() }
    }
}
