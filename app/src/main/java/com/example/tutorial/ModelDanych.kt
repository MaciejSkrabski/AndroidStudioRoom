package com.example.tutorial

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Danie (
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    val name: String,
    val desc: String
)

@Entity(tableName = "osoby")
data class Osoba (
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    val imie: String,
    val nazwisko: String

)

@Entity(tableName = "ogloszenia", foreignKeys = [ForeignKey(entity = Osoba::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("autor"),
    onDelete = ForeignKey.CASCADE)])
data class Ogloszenie (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val tytul: String,
    val tresc: String,
    val autor: Int,
    val tag: String

)

@Entity(tableName="tagi")
data class Tag (
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val tag: String
)