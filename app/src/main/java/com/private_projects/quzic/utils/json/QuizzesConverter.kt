package com.private_projects.quzic.utils.json

import androidx.room.TypeConverter
import com.private_projects.quzic.data.entities.QuizEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class QuizzesConverter {
    private val moshi = Moshi.Builder().build()
    private val adapter = ListJsonAdapter(moshi.adapter(QuizEntity::class.java))

    @TypeConverter
    fun fromQuizzes(quizzes: List<QuizEntity>): String {
        return moshi.adapter<List<QuizEntity>>(
            Types.newParameterizedType(
                List::class.java,
                QuizEntity::class.java
            )
        ).toJson(quizzes)
    }

    @TypeConverter
    fun toQuizzes(quizzesString: String): List<QuizEntity> {
        return moshi.adapter<List<QuizEntity>>(
            Types.newParameterizedType(
                List::class.java,
                QuizEntity::class.java
            )
        ).fromJson(quizzesString) ?: emptyList()
    }
}