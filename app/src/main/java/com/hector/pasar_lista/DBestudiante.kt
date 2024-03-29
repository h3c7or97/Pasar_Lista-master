package com.hector.pasar_lista
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Estudiante::class], version = 1)
public abstract class room  : RoomDatabase(){
    abstract fun dao():EstudianteDAO

    companion object {
        @Volatile
        private var INSTANCE: room? = null

        fun getDatabase(context: Context): room {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized( room::class) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    room::class.java,
                    "estudiante_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}