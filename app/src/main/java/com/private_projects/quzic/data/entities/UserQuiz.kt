package com.private_projects.quzic.data.entities

import androidx.room.Embedded
import androidx.room.Relation


data class UserQuiz(
    @Embedded
    val userEntity: UserEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "owner_id"
    )
    val quizzes: List<QuizEntity>
)
