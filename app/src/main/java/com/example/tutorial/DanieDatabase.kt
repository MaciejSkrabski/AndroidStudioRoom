package com.example.tutorial

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATABASE = "slup_ogloszeniowy"

@Database (
    entities = [Osoba::class, Ogloszenie::class, Tag::class],
    version = 1,
    exportSchema = false
)
abstract class SlupOgloszeniowyDB: RoomDatabase(){
    abstract fun osobaDao(): IOsoba
    abstract fun ogloszenieDao(): IOgloszenie
    abstract fun tagDao(): ITag


    companion object { // spełnia rolę singletonu - zawsze tylko jedna baza w pamięci


        @Volatile
        private var instance: SlupOgloszeniowyDB? = null

        fun getInstance(context: Context): SlupOgloszeniowyDB {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): SlupOgloszeniowyDB {
            return Room.databaseBuilder(context, SlupOgloszeniowyDB::class.java, DATABASE)
                .fallbackToDestructiveMigration().build()
        }
    }
}