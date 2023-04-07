package com.private_projects.quzic.data.entities

import androidx.room.Embedded
import androidx.room.Relation

data class QuizQuestion(
    @Embedded
    val quizEntity: QuizEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "quiz_id"
    )
    val questions: List<QuestionEntity>
)
