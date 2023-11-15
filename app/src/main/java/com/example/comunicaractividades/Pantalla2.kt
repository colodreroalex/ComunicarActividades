package com.example.comunicaractividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comunicaractividades.databinding.ActivityMain2Binding

class Pantalla2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //RECOGER INFORMACION CON INTENT.EXTRAS
        val recogerInfo = intent.extras

        //¿QUE INFO QUEREMOS RECOGER?     //MISMO VALOR   //? Si nombre es null = "Sin nombre recogido"
        val name1 = recogerInfo?.getString("Nombre")?: "Sin nombre recogido"

        //ASIGNAMOS AL RECUADRO INFO RECOGIDA
        binding.terminos.text = "Bienvenid@ " + name1 + " ¿Acepta los términos?"

            //ACEPTAR - RECHAZAR --> MANDAR DATOS A MAINACTIVITY.kt
            binding.bAceptar.setOnClickListener{
                //INTENT ESPECIFICO PARA CADA BOTON AUNQUE REPITA CODIGO
                var intent = Intent(this, MainActivity::class.java)

                //MANDAMOS MENSAJE CON PUTextra (id, mensaje)
                intent.putExtra("mensaje", "Se han aceptado los terminos y condiciones para la app!")

                //VAMOS A LA ACTIVIDADMAIN
                startActivity(intent)

                //Ahora hay que recoger la info mandada desde la otra pantalla
            }

            binding.bRechazar.setOnClickListener{
                //INTENT ESPECIFICO PARA CADA BOTON AUNQUE REPITA CODIGO
                var intent = Intent(this, MainActivity::class.java)

                //MANDAMOS MENSAJE CON PUTextra (id, mensaje)
                intent.putExtra("mensaje", "Se han rechazado los terminos y condiciones para la app!")

                //VAMOS A LA ACTIVIDADMAIN
                startActivity(intent)

                //Ahora hay que recoger la info mandada desde la otra pantalla
            }



    }
}