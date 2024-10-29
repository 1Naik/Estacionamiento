package com.example.estacionamiento

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfiguracionMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_configuracion_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val volverHome: ImageView = findViewById(R.id.imv_conf1)
        volverHome.setOnClickListener {
            //Variable para llamar a la pantalla del home
            val intent = Intent(this, HomeMainActivity::class.java)
            startActivity(intent)
        }

        val volverLogin: TextView = findViewById(R.id.cerrarSesion)
        volverLogin.setOnClickListener {
            //Variable para llamar a la pantalla del login
            val intent = Intent(this, LoginMainActivity::class.java)
            startActivity(intent)
        }

        val irTerminos: TextView = findViewById(R.id.terminos)
        irTerminos.setOnClickListener {
            //Variable para llamar a la pantalla de terminos y servicios
            val intent = Intent(this, TerminosMainActivity::class.java)
            startActivity(intent)
        }

    }
}