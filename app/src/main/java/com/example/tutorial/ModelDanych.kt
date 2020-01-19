package com.example.tutorial

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.StringBufferInputStream

@Entity
data class Danie (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val desc: String
)

@Entity(tableName = "osoby")
data class Osoba (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val imie: String,
    val nazwisko: String

)

@Entity(tableName = "ogloszenia", foreignKeys = [ForeignKey(entity = Osoba::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("autor"),
    onDelete = ForeignKey.CASCADE)])
data class Ogloszenie (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val tytul: String,
    val tresc: String,
    val autor: Int
)

@Entity(tableName="tagi", foreignKeys = [ForeignKey(entity = Ogloszenie::class,
    parentColumns = arrayOf("tytul"),
    childColumns = arrayOf("ogloszenie"))])
data class Tag (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val tag: String,
    val ogloszenie: String
)