package com.example.estacionamiento

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Estacionamiento3MainActivity : AppCompatActivity() {
    //Inicializar variables antes de usarlas
    private lateinit var editEstacionamiento: EditText
    private lateinit var editEstado: EditText
    private lateinit var botonAgregar: Button
    private lateinit var botonActualizar: Button
    private lateinit var botonEliminar: Button
    private lateinit var lista: ListView
    private val estList = ArrayList<Estacionamiento>()
    private lateinit var adapter: ArrayAdapter<Estacionamiento>
    private var selectedIndex: Int = -1

    //Oncreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_estacionamiento3_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editEstacionamiento = findViewById(R.id.editEstacionamiento)
        editEstado = findViewById(R.id.editEstado)
        botonAgregar = findViewById(R.id.btnAgregar)
        botonActualizar = findViewById(R.id.btnActualizar)
        botonEliminar = findViewById(R.id.btnEliminar)
        lista = findViewById(R.id.lista)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, estList)
        lista.adapter = adapter

        botonAgregar.setOnClickListener { agregarEst() }
        botonActualizar.setOnClickListener { actualizarEst() }
        botonEliminar.setOnClickListener { eliminarEst() }

        lista.setOnItemClickListener { _, _, position, _ ->
            selectedIndex = position
            val estacionamientoSeleccionado = estList[position]
            editEstacionamiento.setText(estacionamientoSeleccionado.nombre)
            editEstado.setText(estacionamientoSeleccionado.estado)
        }

        val volverHome: Button = findViewById(R.id.btnVolver)
        volverHome.setOnClickListener {
            //Variable para llamar a la pantalla del home
            val intent = Intent(this, HomeMainActivity::class.java)
            startActivity(intent)
        }

    }

    //Fuera Oncreate
    private fun agregarEst() {
        val nombre = editEstacionamiento.text.toString()
        val estado = editEstado.text.toString()
        //Valida si los datos estan vacios
        if (nombre.isNotEmpty() && estado.isNotEmpty()) {
            //Agrega los datos a la lista
            estList.add(Estacionamiento(nombre, estado))
            adapter.notifyDataSetChanged()
            //Limpia los editText
            editEstacionamiento.text.clear()
            editEstado.text.clear()
            Toast.makeText(this, "Estacionamiento agregado", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Ingresa un estacionamiento y su estado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun actualizarEst() {
        if (selectedIndex >= 0) {
            val nombre = editEstacionamiento.text.toString()
            val estado = editEstado.text.toString()
            //Valida si los datos estan vacios
            if (nombre.isNotEmpty() && estado.isNotEmpty()) {
                //Agrega los datos a la lista
                estList[selectedIndex] = Estacionamiento(nombre, estado)
                adapter.notifyDataSetChanged()
                //Limpia los editText
                editEstacionamiento.text.clear()
                editEstado.text.clear()
                selectedIndex = -1
                Toast.makeText(this, "Estacionamiento actualizado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ingresa un estacionamiento y su estado", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Selecciona el estacionamiento a actualizar", Toast.LENGTH_SHORT).show()
        }
    }

    private fun eliminarEst() {
        if (selectedIndex >= 0) {
            //Elimina el estacionamiento que fue seleccionado
            estList.removeAt(selectedIndex)
            adapter.notifyDataSetChanged()
            //Limpia los editText
            editEstacionamiento.text.clear()
            editEstado.text.clear()
            selectedIndex = -1
            Toast.makeText(this, "Estacionamiento eliminado", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Selecciona el estacionamiento a eliminar", Toast.LENGTH_SHORT).show()
        }
    }
}