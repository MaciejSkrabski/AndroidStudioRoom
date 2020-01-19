package com.example.tutorial

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Danie::class], version = 1) //Musi być >= 1
abstract class DanieDatabase: RoomDatabase(){
    abstract fun danieDao(): IDanie
}