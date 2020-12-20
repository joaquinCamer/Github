package com.example.listchoiceapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla")
data class Items(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val materia: String
)

