package com.example.tutorial

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface IDanie {
    @Query("SELECT * FROM danie")
    fun pobierzWszystkieDania(): List<Danie>

    /*@Query("UPDATE danie SET NAME = $n, DESC = $d WHERE ID = $i")
    fun zmienDanie(n:String, d:String, i:Int): List<Danie>*/

    @Insert
    fun dodajDanie(danie: Danie)
}