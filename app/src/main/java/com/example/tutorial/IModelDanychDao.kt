package com.example.tutorial

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao //Data Access Object
interface IDanie {
    @Query("SELECT * FROM danie")
    fun pobierzWszystkieDania(): List<Danie>

    /*@Query("UPDATE danie SET NAME = $n, DESC = $d WHERE ID = $i")
    fun zmienDanie(n:String, d:String, i:Int): List<Danie>*/

    @Insert
    fun dodajDanie(danie: Danie)
}

@Dao
interface IOsoba {
    @Query("SELECT * FROM osoby")
    fun wszystkieOsoby(): List<Osoba>

    @Insert
    fun dodajOsobe(osoba: Osoba)

    @Delete
    fun delete()
}

@Dao
interface ITag {
    @Query("SELECT * FROM tagi")
    fun wszystkieOsoby(): List<Tag>


    @Insert
    fun dodajTag(tag: Tag)

    @Delete
    fun delete()
}

@Dao
interface IOgloszenie {
    @Query("SELECT * FROM ogloszenia")
    fun wszystkieOgloszenia(): List<Ogloszenie>

    @Insert
    fun dodajOgloszenie(ogloszenie: Ogloszenie)

    @Delete
    fun delete()
}