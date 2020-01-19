package com.example.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import android.widget.Toast
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            this, DanieDatabase::class.java,"meal_database"
        )
            .allowMainThreadQueries()
            .build()

        val wszystkieDania = db.danieDao().pobierzWszystkieDania()

        wszystkieDania.forEach{
            textView.append("\n id: ${it.id}, nazwa:${it.name}, opis:${it.desc}")
        }
        d("dania", "ile dań? ${wszystkieDania.size}")


        var add = findViewById<Button>(R.id.buttonAdd)
        add.setOnClickListener {
            Toast.makeText(this, "Guzik!", Toast.LENGTH_SHORT).show()
            dodaj(db)
        }
    }

    fun dodaj(db: DanieDatabase) {
        db.danieDao().dodajDanie(Danie(name=edit_text_name.text.toString(), desc=edit_text_desc.text.toString()))
    }
}
