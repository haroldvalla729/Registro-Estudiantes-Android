package com.example.registroestudiantes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cargar el diseño XML
        setContentView(R.layout.activity_main)

        // Obtener los componentes de la pantalla
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val rgCarreras = findViewById<RadioGroup>(R.id.rgCarreras)
        val cbVirtual = findViewById<CheckBox>(R.id.cbVirtual)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)

        // Programar el boton Registrar
        btnRegistrar.setOnClickListener {

            // Obtener el nombre ingresado
            val nombre = etNombre.text.toString().trim()

            // Validar que el nombre no este vacio
            if (nombre.isEmpty()) {
                Toast.makeText(
                    this,
                    "Por favor, ingresa tu nombre",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // Comprobar que se haya seleccionado una carrera
            val idSeleccionado = rgCarreras.checkedRadioButtonId

            if (idSeleccionado == -1) {
                Toast.makeText(
                    this,
                    "Selecciona una carrera universitaria",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // Obtener la carrera seleccionada
            val radioSeleccionado =
                findViewById<RadioButton>(idSeleccionado)

            val carrera = radioSeleccionado.text.toString()

            // Determinar la modalidad de estudio
            val modalidad = if (cbVirtual.isChecked) {
                "Virtual"
            } else {
                "Presencial"
            }

            // Crear el Intent para abrir la segunda pantalla
            val intent = Intent(this, ResumenActivity::class.java)

            // Enviar los tres datos
            intent.putExtra("nombre", nombre)
            intent.putExtra("carrera", carrera)
            intent.putExtra("modalidad", modalidad)

            // Abrir la segunda pantalla
            startActivity(intent)
        }
    }
}