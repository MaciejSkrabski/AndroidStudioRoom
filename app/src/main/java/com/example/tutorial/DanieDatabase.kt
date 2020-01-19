package com.example.tutorial

import androidx.room.Database
import androidx.room.RoomDatabase

//Warstwa abstrakcji nad SQLite
@Database(entities = [Danie::class], version = 1) //Musi być >= 1
abstract class DanieDatabase: RoomDatabase(){
    abstract fun danieDao(): IDanie
}

@Database(entities = [Osoba::class, Ogloszenie::class, Tag::class], version = 1)
abstract class SlupOgloszeniowyDB: RoomDatabase(){
    abstract fun osobaDao(): IOsoba
    abstract fun ogloszenieDao(): IOgloszenie
}