package com.example.tutorial

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Danie (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val desc: String
)