package com.hector.pasar_lista
import android.content.ContentValues
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EstudianteDAO {
    @Query("SELECT * from estudiante")
    fun getestudiante(): List<Estudiante>

    @Insert
    suspend fun insert(estudiante: Estudiante)

    // @Query("DELETE FROM producto")
    // fun deleteAll()
}