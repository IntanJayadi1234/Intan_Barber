package org.intan.barbershop.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
//Kelas harus berupa kelas abstrak dan memperluas RoomDatabase
@Database(entities = [BarberShop::class], version = 1, exportSchema = false)
abstract class BarberShopDatabase : RoomDatabase() {

    abstract val barberShopDAO: BarberShopDAO
//Companion Object Kotlin adalah sebuah deklarsi objek yang ada di dalam sebuah kelas yang bisa ditandai 'companion' keyword.
    companion object {
        const val DATABASE_NAME = "barbershop_database"
        @Volatile
        private var INSTANCE: BarberShopDatabase? = null

        fun getInstance(context: Context) : BarberShopDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            BarberShopDatabase::class.java,
                            DATABASE_NAME
                        )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}