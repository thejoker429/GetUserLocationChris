package edu.seminolestate.getuserlocation.HistoryDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope

@Database(
    entities = [],
    version = 1,
    exportSchema = false
)

class HistoryData : RoomDatabase() {
    abstract fun DataDao(): DataDao

    companion object {
        @Volatile
        private var instance: HistoryData? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): HistoryData =

            this.instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    HistoryData::class.java,
                    "HistoryData"
                ).build()

                this.instance = instance

                instance
            }
    }
}