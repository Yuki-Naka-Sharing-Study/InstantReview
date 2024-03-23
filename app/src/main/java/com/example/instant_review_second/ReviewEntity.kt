package com.example.instant_review_second

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "review_data_table")
data class ReviewEntity(
    @PrimaryKey
    var reviewId: Int,

    @ColumnInfo(name = "name_of_instant")
    var nameOfInstant: String?,

    @ColumnInfo(name = "comment_of_want")
    var commentOfWant: String?,

    @ColumnInfo(name = "comment_of_review")
    var commentOfReview: String?,
)