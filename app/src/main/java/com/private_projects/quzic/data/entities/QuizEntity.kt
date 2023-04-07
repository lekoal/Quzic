package com.private_projects.quzic.data.entities

import androidx.room.*
import com.private_projects.quzic.utils.json.QuestionConverter

@Entity(
    tableName = "quiz",
    indices = [Index(value = ["owner_id"], unique = true)],
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["id"],
        childColumns = ["owner_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class QuizEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "owner_id")
    val ownerId: Long,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "questions")
    @TypeConverters(QuestionConverter::class)
    val questions: List<QuestionEntity>?,
    @ColumnInfo(name = "time")
    val time: Int?
)
