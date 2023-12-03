package com.example.tarefacadastro

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.example.tarefacadastro.database.Animal
import com.example.tarefacadastro.database.MyDb

private const val PREF_NAME  = "name"
private const val PREF_TUTOR  = "tutor"
private const val PREF_CACHORRO  = "Cachorro"
private const val PREF_GATO  = "gato"
private const val PREF_OUTROS  = "OUTROS"
private const val PREF  = "PREF"

 class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.NomePet)
        val tutor = findViewById<EditText>(R.id.NomeTutor)
        val cachorro = findViewById<CheckBox>(R.id.Cachorro)
        val gato = findViewById<CheckBox>(R.id.Cat)
        val outros = findViewById<CheckBox>(R.id.Outros)
        val btn = findViewById<Button>(R.id.Cadastrar)

        val pref = getSharedPreferences(PREF, Context.MODE_PRIVATE)


        name.setText(pref.getString( PREF_NAME, ""))
        tutor.setText(pref.getString( PREF_TUTOR, "").toString())
        cachorro.isChecked = pref.getBoolean(PREF_CACHORRO, false)
        gato.isChecked = pref.getBoolean(PREF_GATO , false)
        outros.isChecked = pref.getBoolean(PREF_OUTROS , false)
        btn.setOnClickListener{
            val edit =   pref.edit()
            edit.putString(PREF_NAME, name.toString())
            edit.putString(PREF_TUTOR, tutor.toString())
            edit.putBoolean(PREF_CACHORRO,cachorro.isChecked)
            edit.putBoolean(PREF_GATO,gato.isChecked)
            edit.putBoolean(PREF_OUTROS,outros.isChecked)
            edit.apply()
        }
        MyDb.getIntance(this).bookDao().insertAnimal(
            Animal(1,"Belinha", "Jorge", "femea")
        )
        MyDb.getIntance(this).bookDao().insertAnimais(
            Animal(1,"Paçoca", "Julia", "macho"),
            Animal(2,"Fred", "Carlos","macho")
        )
        MyDb.getIntance(this).bookDao().apply {
            Animal(1,"Anne", "Ana", "femea")
            insertAnimais(
                Animal(1,"Paçoca", "Julia", "macho"),
                Animal(2,"Fred", "Carlos","macho")
            )
        }

    }



    }
