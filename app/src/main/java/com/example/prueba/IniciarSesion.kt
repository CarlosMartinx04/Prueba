package com.example.prueba

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IniciarSesion : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)

        var editTextCorreo = findViewById<EditText>(R.id.inSeEditTextCorreo)
        var editTextContraseña = findViewById<EditText>(R.id.inSeEditTextContraseña)
        var buttonIniciarSesion = findViewById<Button>(R.id.inSeBtnIniciarSesion)

    }
}