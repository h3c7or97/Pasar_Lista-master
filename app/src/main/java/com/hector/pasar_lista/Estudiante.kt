package com.hector.pasar_lista

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "estudiante")
class Estudiante(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int) {
    @ColumnInfo(name = "nombre")  var nombre:String? = null
    @ColumnInfo(name = "apellido")  var apellido:String? = null
}