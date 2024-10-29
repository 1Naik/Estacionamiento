package com.example.estacionamiento

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Cambiar pantalla configuracion
        val cambiarConfig: ImageView = findViewById(R.id.imv_home1)
        cambiarConfig.setOnClickListener {
            //Variable para llamar a la pantalla de configuracion
            val intent = Intent(this, ConfiguracionMainActivity::class.java)
            startActivity(intent)
        }


        //Cambiar pantalla botones grandes
        val cambiarSector1: Button = findViewById(R.id.btnHome1)
        cambiarSector1.setOnClickListener {
            //Variable para llamar a la pantalla del sector 1
            val intent = Intent(this, Estacionamiento1MainActivity::class.java)
            startActivity(intent)
        }

        val cambiarSector2: Button = findViewById(R.id.btnHome2)
        cambiarSector2.setOnClickListener {
            //Variable para llamar a la pantalla del sector 2
            val intent = Intent(this, Estacionamiento2MainActivity::class.java)
            startActivity(intent)
        }



        val cambiarEst1: Button = findViewById(R.id.btnHomeSector1)
        cambiarEst1.setOnClickListener {
            //Variable para llamar a la pantalla del sector 1
            val intent = Intent(this, Estacionamiento1MainActivity::class.java)
            startActivity(intent)
        }
        val cambiarEst2: Button = findViewById(R.id.btnHomeSector2)
        cambiarEst2.setOnClickListener {
            //Variable para llamar a la pantalla del sector 2
            val intent = Intent(this, Estacionamiento2MainActivity::class.java)
            startActivity(intent)
        }
        val cambiarEst3: Button = findViewById(R.id.btnHomeSector3)
        cambiarEst3.setOnClickListener {
            //Variable para llamar a la pantalla del sector 3
            val intent = Intent(this, Estacionamiento3MainActivity::class.java)
            startActivity(intent)
        }
        val cambiarEst4: Button = findViewById(R.id.btnHomeSector4)
        cambiarEst4.setOnClickListener {
            //Variable para llamar a la pantalla del sector 4
            val intent = Intent(this, Estacionamiento4MainActivity::class.java)
            startActivity(intent)
        }
        val cambiarEst5: Button = findViewById(R.id.btnHomeSector5)
        cambiarEst5.setOnClickListener {
            //Variable para llamar a la pantalla del sector 5
            val intent = Intent(this, Estacionamiento5MainActivity::class.java)
            startActivity(intent)
        }

    }
}