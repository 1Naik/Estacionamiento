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

class RegistroMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cambiarLogin2: TextView = findViewById(R.id.tvCuentaExistente)
        cambiarLogin2.setOnClickListener {
            //Variable para llamar a la pantalla del login
            val intent = Intent(this, LoginMainActivity::class.java)
            startActivity(intent)
        }

        val inputUsuario = findViewById<EditText>(R.id.etilRegister1)
        val inputCorreo = findViewById<EditText>(R.id.etilRegister2)
        val inputPassword = findViewById<EditText>(R.id.etilRegister3)

        //Accion de boton registro
        val btnRegistro = findViewById<Button>(R.id.btnRegister1)
        btnRegistro.setOnClickListener {
            val usuario = inputUsuario.text.toString()
            val correo = inputCorreo.text.toString()
            val password = inputPassword.text.toString()

            // Validar nombre de usuario
            if (usuario.isEmpty()) {
                Toast.makeText(
                    this,
                    "El nombre de usuario no puede estar vacio",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            //Validar el correo
            if (correo.isEmpty()) {
                Toast.makeText(
                    this,
                    "El correo electrónico no puede estar vacio",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                Toast.makeText(this, "Ingrese un correo electrónico válido", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            //Validar la contraseña
            if (password.isEmpty()) {
                Toast.makeText(this, "La contraseña no puede estar vacia", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            } else if (password.length < 6) {
                Toast.makeText(
                    this,
                    "La contraseña debe tener al menos 6 caracteres",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            try {
                //Guardar los datos
                val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()

                editor.putString("usuario", usuario)
                editor.putString("correo", correo)
                editor.putString("password", password)
                editor.apply()

                Toast.makeText(this, "Registrado exitosamente", Toast.LENGTH_SHORT).show()

                // Redirigir a login
                val intent = Intent(this, LoginMainActivity::class.java)
                startActivity(intent)

        } catch (e: Exception){
            Toast.makeText(this, "Error al guardar los datos: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}