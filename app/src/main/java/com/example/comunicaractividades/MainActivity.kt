package com.example.comunicaractividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comunicaractividades.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* ACTIVAR BINDING */
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //AL PULSAR SOBRE EL BOTON ACCEDER DEL ACTIVITY MAIN
        binding.boton.setOnClickListener{
            var nombre = binding.nombre.text.toString()
            val intent = Intent(this,Pantalla2::class.java )   //Intent() siempre se le pasan 2 parametros
                                                                                        //this --> contexto en el que estamos
                                                                                        //A que pantalla le mandamos la info
            //DECIMOS CON .putExtra la info que queremos enviar - //MISMO VALOR "nombre"
            intent.putExtra("Nombre", nombre)

            //Ahora deberia de llevarte a la 2 pantalla, hacemos start
            //Y MANDAMOS INFO, ¡HAY QUE RECOGERLA!, VAMOS A PANTALLA2.kt
            startActivity(intent)
        }



        //RECOGER INFO DE PANTALLA2 Intent
        val recogerInfo = intent.extras
        val mensajeRecoger = recogerInfo?.getString("mensaje")?: "Sin mensaje recogido"

        //ASIGNAMOS TEXTO RECOGIDO A EL LABEL CORRESPONDIENTE
        binding.info.text = mensajeRecoger
    }
}