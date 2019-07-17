package com.hector.pasar_lista

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_estudiante.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



class AddEstudiante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_estudiante)
        val db = room.getDatabase(this)
        var listaestudiante=ArrayList<Estudiante>()

        btnagregar.setOnClickListener(View.OnClickListener
        {

            var est = Estudiante(0)
            est.nombre = txtnombre.text.toString()
            est.apellido = txtapellido.text.toString()
            GlobalScope.launch {
                db.dao().insert(est)
                listaestudiante= db.dao().getestudiante() as ArrayList<Estudiante>

                finish()

            }
        })

        btncancelar.setOnClickListener(View.OnClickListener
        {
            Toast.makeText(baseContext, "Cancelando Registro Estudiante", Toast.LENGTH_SHORT).show()
                finish()
        })
    }

}