package com.example.tutorial

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import android.widget.Toast
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val db = SlupOgloszeniowyDB.getInstance(this)
        val o = Osoba(0, "Maciek", "Skrabski")


        getOsoby(db)

        val add = findViewById<Button>(R.id.buttonAdd)
        add.setOnClickListener {
            Toast.makeText(this, "Guzik!", Toast.LENGTH_SHORT).show()
            d("oto obiekt:", "${o.toString()}")
            dodajOsobe(db, o)
        }


    }

    fun dodajOsobe(db: SlupOgloszeniowyDB, o:Osoba){
        // Start a coroutine
        GlobalScope.launch{
            d("tgb", "${o.toString()}")
            db.osobaDao().dodajOsobe(o)}
    }

    fun getOsoby(db: SlupOgloszeniowyDB){

        // Start a coroutine
        GlobalScope.launch{
            d("raz", "raz")

            val l = db.osobaDao().wszystkieOsoby()
            d("dł: ", "${l.size}")
            l.forEach {

                d("Ogloszenia!: ", "${it.imie}, ${it.nazwisko}") }
        }
    }
}
