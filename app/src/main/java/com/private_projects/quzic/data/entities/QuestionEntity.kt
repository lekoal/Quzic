package com.private_projects.quzic.data.entities

import androidx.room.*

@Entity(
    tableName = "question",
    indices = [Index(value = ["quiz_id"], unique = true)],
    foreignKeys = [ForeignKey(
        entity = QuizEntity::class,
        parentColumns = ["id"],
        childColumns = ["quiz_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "quiz_id")
    val quizId: Long,
    @ColumnInfo(name = "text")
    val text: String?,
    @ColumnInfo(name = "photo")
    val photo: String?,
    @ColumnInfo(name = "audio")
    val audio: String?,
    @ColumnInfo(name = "video")
    val video: String?
)
