package br.edu.iftm.estudo_trabalho_3.infrastructure

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.iftm.estudo_trabalho_3.application.KidDAO
import br.edu.iftm.estudo_trabalho_3.domain.Kid

@Database(
    entities = [Kid::class],
    version = 1,
    exportSchema = true
)
abstract class AppDataBaseSQLite : RoomDatabase() {

    abstract fun kidDAO(): KidDAO

    companion object{
        @Volatile private var INSTANCE: AppDataBaseSQLite? = null

        fun getInstance(context: Context): AppDataBaseSQLite =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBaseSQLite::class.java,
                    "app_sqlite.db"
                ).build().also { INSTANCE = it }
            }
    }
}