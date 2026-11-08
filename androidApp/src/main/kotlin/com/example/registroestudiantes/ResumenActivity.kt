
package com.example.registroestudiantes

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class ResumenActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cargar el diseño XML de la segunda pantalla
        setContentView(R.layout.activity_resumen)

        // Obtener los TextView del diseño
        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        val tvCarrera = findViewById<TextView>(R.id.tvCarrera)
        val tvModalidad = findViewById<TextView>(R.id.tvModalidad)

        // Recuperar los datos enviados desde MainActivity
        val nombre = intent.getStringExtra("nombre")
        val carrera = intent.getStringExtra("carrera")
        val modalidad = intent.getStringExtra("modalidad")

        // Mostrar los datos recibidos
        tvNombre.text = nombre ?: "No disponible"
        tvCarrera.text = carrera ?: "No disponible"
        tvModalidad.text = modalidad ?: "No disponible"
    }
}
