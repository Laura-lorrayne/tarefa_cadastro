package com.example.tarefacadastro.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Animal::class], version = 1)
abstract class MyDataBase : RoomDatabase(){
    abstract  fun bookDao(): AnimalDao

}

object MyDb{
    fun getIntance(context: Context): MyDataBase =
        Room.databaseBuilder(
            context,
            MyDataBase::class.java,
            "my-database"
        ).build()
}