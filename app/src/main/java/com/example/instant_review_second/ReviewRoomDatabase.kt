package com.example.instant_review_second

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = [Review::class], version = 1, exportSchema = false)
abstract class ReviewRoomDatabase : RoomDatabase() {

    abstract fun reviewDao(): ReviewDao

    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
        @Volatile
        private var INSTANCE: ReviewRoomDatabase ? = null

        fun getDatabase(context: Context): ReviewRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = databaseBuilder(
                    context.applicationContext,
                    ReviewRoomDatabase::class.java, "review _database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}