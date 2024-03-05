package com.example.instant_review_second

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ReviewDao {
    @Insert
    fun insertAll(vararg reviews: Review)

    @Update
    fun updateReviews(vararg reviews: Review)

    @Delete
    fun delete(review: Review)

    @Query("SELECT * FROM review_data_table")
    fun getAll(): List<Review>
}