package com.example.prueba

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType{
    BASIC
}

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setUp(email ?: "", provider ?: "")
    }

    private fun setUp(email:String, provider:String){

        title="Inicio"
        val Email = findViewById<TextView>(R.id.hmEmailText)
        val Provider = findViewById<TextView>(R.id.hmProviderText)
        val ButtonSalir = findViewById<Button>(R.id.hmButtonSalir)

        Email.text=email
        Provider.text=provider
        ButtonSalir.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }


    }

}