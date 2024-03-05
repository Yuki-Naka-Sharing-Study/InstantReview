package com.example.instant_review_second

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "review_data_table")
data class Review(
    @PrimaryKey
    val reviewDay: Int,

    @ColumnInfo(name = "name_of_instant")
    val nameOfInstant: String,

    @ColumnInfo(name = "comment_of_want")
    val commentOfWant: String,

    @ColumnInfo(name = "comment_of_review")
    val commentOfReview: String,
)