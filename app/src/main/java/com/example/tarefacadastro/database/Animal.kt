package com.example.tarefacadastro.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Animal(
    @PrimaryKey val id : Int,
    @ColumnInfo( name ="name") val name: String,
    @ColumnInfo(name ="nameTutor") val nameTutor: String,
    @ColumnInfo(name ="especie") val especie: String,
)