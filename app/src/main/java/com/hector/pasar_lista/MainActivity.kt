package com.hector.pasar_lista

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listaestudiante=ArrayList<Estudiante>()


        val db = room.getDatabase(this)

      /*  var p=Estudiante(0)
        p.nombre="hector"
        p.apellido="Avendaño"
        var p1=Estudiante(1)
        p1.nombre="Erick"
        p1.apellido="Avendaño"*/




        GlobalScope.launch {
            listaestudiante= db.dao().getestudiante() as ArrayList<Estudiante>

        }


        btncargar.setOnClickListener {

            GlobalScope.launch {
                //       db.dao().insert(est)
                listaestudiante= db.dao().getestudiante() as ArrayList<Estudiante>
            }
            Toast.makeText(applicationContext,listaestudiante.size.toString(), Toast.LENGTH_SHORT).show()
            recycleestudiante.layoutManager= LinearLayoutManager(applicationContext, LinearLayout.VERTICAL,false)
            var adapter=AdapEstudiante(listaestudiante)
            recycleestudiante.adapter=adapter
        }

        // var txtnombre = findViewById(R.id.txtnombre) as EditText
        // var txtapellido = findViewById(R.id.txtnombre) as EditText

        /*btninsertar.setOnClickListener {
        }*/

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.NuevoEst -> {
                val ListSong = Intent(applicationContext, AddEstudiante::class.java)
                startActivityForResult(ListSong, 4444)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun insertar()
    {

    }



}