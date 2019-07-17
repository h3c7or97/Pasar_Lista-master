package com.hector.pasar_lista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycle_estudiante.view.*

class AdapEstudiante(val listaestudiante:ArrayList<Estudiante>): RecyclerView.Adapter<AdapEstudiante.Viewholder>() {
    class Viewholder(itemview: View):RecyclerView.ViewHolder(itemview)
    {
        val tvnombre: TextView =itemview.tvnombre
        val tvapellido: TextView =itemview.tvapellido
        val cb1: CheckBox =itemview.cb1
        val ib2: ImageButton =itemview.ib2


    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdapEstudiante.Viewholder
    {
        val v= LayoutInflater.from(p0.context).inflate(R.layout.item_recycle_estudiante,p0,false)
        return Viewholder(v)
    }
    override fun getItemCount(): Int {
        return listaestudiante.size
    }
    override fun onBindViewHolder(p0: AdapEstudiante.Viewholder, p1: Int) {
        p0.tvnombre.setText(listaestudiante.get(p1).nombre)
        p0.tvapellido.setText(listaestudiante.get(p1).apellido.toString())

        p0.itemView.setOnClickListener {
            Toast.makeText(p0.itemView.context,"Evento Click", Toast.LENGTH_SHORT).show()
        }
    }
}