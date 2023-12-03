package com.example.tarefacadastro.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface AnimalDao {
    @Query("SELECT *FROM animal")
    fun getAnimal() : List<Animal>

    @Insert
    fun insertAnimal(book: Animal)

    @Insert
    fun insertAnimais(vararg book: Animal)

    @Update
    fun updateAnimal(book: Animal)

}