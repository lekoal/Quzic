package com.private_projects.quzic.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.private_projects.quzic.utils.json.QuizzesConverter

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "hash")
    val passwordHash: String,
    @ColumnInfo(name = "quizzes")
    @TypeConverters(QuizzesConverter::class)
    val quizzes: List<QuizEntity>?
)
