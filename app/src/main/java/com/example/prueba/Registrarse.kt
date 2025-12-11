package com.example.prueba

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore

class Registrarse : AppCompatActivity() {
    val ButtonRegistrarse = findViewById<Button>(R.id.regBtnRegistrarse)
    val Correo = findViewById<EditText>(R.id.regEditTextCorreo).text.toString()
    val Contraseña = findViewById<EditText>(R.id.regEditTextContraseña).text.toString()
    val ConfirmarContraseña = findViewById<EditText>(R.id.regEditTextConfirmarContraseña).text.toString()

    private val db = FirebaseFirestore.getInstance()
    lateinit var firebaseAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrarse)
        val Nombre = findViewById<EditText>(R.id.regEditTextNombre).text.toString()

    }

    private fun setUp(){
        title = "Autenticacion"
        ButtonRegistrarse.setOnClickListener(){
            if(Correo.isNotEmpty()&&Contraseña.isNotEmpty()&&ConfirmarContraseña.isNotEmpty()){}
        }
    }

}