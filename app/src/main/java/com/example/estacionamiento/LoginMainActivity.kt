package com.example.estacionamiento

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Cambiar a pantalla registro
        val cambiarRegistro1: TextView = findViewById(R.id.tvNuevaCuenta)
        cambiarRegistro1.setOnClickListener {
            //Variable para llamar a la pantalla del registro
            val intent = Intent(this, RegistroMainActivity::class.java)
            startActivity(intent)
        }

        val usuario = findViewById<EditText>(R.id.etilLogin1)
        val password = findViewById<EditText>(R.id.etilLogin2)
        val btnInicio = findViewById<Button>(R.id.btnLogin1)

        btnInicio.setOnClickListener {
            //Descartar espacios vacios
            val usuarioInput = usuario.text.toString().trim()
            val passwordInput = password.text.toString().trim()

            //Validar datos vacios
            if (usuarioInput.isEmpty()) {
                Toast.makeText(
                    this,
                    "El nombre de usuario no puede estar vacío",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            if (passwordInput.isEmpty()) {
                Toast.makeText(this, "La contraseña no puede estar vacía", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            try {
                //Cargar datos
                val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                val datoUsuario = sharedPreferences.getString("usuario", "")
                val datoPassword = sharedPreferences.getString("password", "")

                //Verificar si los datos coinciden
                if (usuarioInput == datoUsuario && passwordInput == datoPassword) {
                    //Verificacion exitosa
                    val intent = Intent(this, HomeMainActivity::class.java)
                    startActivity(intent)
                } else {
                    //Datos incorrectos
                    Toast.makeText(this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Error al guardar los datos: ${e.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}