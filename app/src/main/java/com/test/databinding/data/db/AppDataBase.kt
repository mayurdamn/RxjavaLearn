package com.test.databinding.data.db

import android.content.Context
import android.support.v4.app.INotificationSideChannel
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [AddUrlEmailModel::class], version = 1)
abstract class AppDataBase :RoomDatabase() {

    abstract fun urlEmailDao(): AddUrlEmailDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null
        private val LOCK= Any()


        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: buildDatabase(context).also { db ->
                INSTANCE = db
            }
        }
        private fun buildDatabase(context: Context) =
              Room.databaseBuilder(context,
                        AppDataBase::class.java, "mail.db")
                        .build()



        fun destroyInstance() {
            INSTANCE = null
        }
    }
}