package com.private_projects.quzic.utils.json

import androidx.room.TypeConverter
import com.private_projects.quzic.data.entities.QuestionEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class QuestionConverter {
    private val moshi = Moshi.Builder().build()
    private val adapter = ListJsonAdapter(moshi.adapter(QuestionEntity::class.java))

    @TypeConverter
    fun fromQuestion(questions: List<QuestionEntity>): String {
        return moshi.adapter<List<QuestionEntity>>(
            Types.newParameterizedType(
                List::class.java,
                QuestionEntity::class.java
            )
        ).toJson(questions)
    }

    @TypeConverter
    fun toQuestion(questionsString: String): List<QuestionEntity> {
        return moshi.adapter<List<QuestionEntity>>(
            Types.newParameterizedType(
                List::class.java,
                QuestionEntity::class.java
            )
        ).fromJson(questionsString) ?: emptyList()
    }
}