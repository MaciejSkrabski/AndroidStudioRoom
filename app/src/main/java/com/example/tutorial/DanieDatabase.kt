package com.example.tutorial

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Danie::class], version = 0)
abstract class DanieDatabase: RoomDatabase(){
    abstract fun danieDao(): IDanie
}