package com.example.instant_review_second

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ReviewDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReview(vararg reviews: ReviewEntity)

    @Update
    fun updateReviews(vararg reviews: ReviewEntity)

    @Delete
    fun delete(review: ReviewEntity)

    @Query("SELECT * FROM review_data_table")
    fun getAll(): List<ReviewEntity>
}