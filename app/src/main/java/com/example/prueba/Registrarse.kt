package com.example.prueba

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.inject.Provider
import kotlin.jvm.Throws

class Registrarse : ComponentActivity() {
    lateinit var ButtonRegistrarse:Button
    lateinit var ButtonAcceder:Button
    lateinit var Correo:EditText
    lateinit var Contraseña:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)
        ButtonRegistrarse = findViewById<Button>(R.id.regBtnRegistrarse)
        ButtonAcceder = findViewById<Button>(R.id.regBtnAcceder)
        Correo = findViewById<EditText>(R.id.regEditTextCorreo)
        Contraseña = findViewById<EditText>(R.id.regEditTextContraseña)
        val analytics:FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integracion de Firebase completa")
        analytics.logEvent("InitScreen", bundle)
        setUp()
    }

    private fun setUp(){
        title = "Autenticacion"
        ButtonRegistrarse.setOnClickListener{
            if(Correo.text.isNotEmpty()&&Contraseña.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(Correo.text.toString(), Contraseña.text.toString())
                    .addOnCompleteListener{
                    if(it.isSuccessful){
                        showHome(it.result?.user?.email?:"", ProviderType.BASIC)
                    } else {
                        showAlert()
                        Toast.makeText(this, "No se ha encontrado las credenciales", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        ButtonAcceder.setOnClickListener {
            if (Correo.text.isNotEmpty() && Contraseña.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(Correo.text.toString(), Contraseña.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                        } else {
                            showAlert()
                        }
                    }
            }
        }
    }


    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando el usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog:AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String, provider: ProviderType){

        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)

    }


}