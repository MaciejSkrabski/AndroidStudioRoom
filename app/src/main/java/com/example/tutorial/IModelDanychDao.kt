package com.example.tutorial

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface IOsoba {
    @Query("SELECT * FROM osoby")
    suspend fun wszystkieOsoby(): List<Osoba>

    @Query("SELECT * FROM osoby WHERE id=:id")
    suspend fun OsobaPrzezId(id: Int): Osoba

    @Insert
    suspend fun dodajOsobe(osoba: Osoba)

    @Delete
    suspend fun delete(osoba: Osoba)
}

@Dao
interface ITag {
    @Query("SELECT * FROM tagi")
    suspend fun wszystkieOsoby(): List<Tag>

    @Query("SELECT * FROM tagi WHERE id=:id")
    suspend fun TagPrzezId(id: Int): Tag

    @Insert
    suspend fun dodajTag(tag: Tag)

    @Delete
    suspend fun delete(tag: Tag)
}

@Dao
interface IOgloszenie {
    @Query("SELECT * FROM ogloszenia")
    suspend fun wszystkieOgloszenia(): List<Ogloszenie>

    @Query("SELECT * FROM ogloszenia WHERE id=:id")
    suspend fun ogloszeniePrzezId(id: Int): Ogloszenie


    @Insert
    suspend fun dodajOgloszenie(ogloszenie: Ogloszenie)

    @Delete
    suspend fun delete(ogloszenie: Ogloszenie)
}