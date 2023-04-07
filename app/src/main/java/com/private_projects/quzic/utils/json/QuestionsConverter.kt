package com.private_projects.quzic.utils.json

import androidx.room.TypeConverter
import com.private_projects.quzic.data.entities.QuestionEntity
import com.squareup.moshi.Moshi

class QuestionConverter {
    private val moshi = Moshi.Builder().build()
    private val adapter = moshi.adapter(QuestionEntity::class.java)

    @TypeConverter
    fun fromQuestion(question: QuestionEntity): String {
        return adapter.toJson(question)
    }

    @TypeConverter
    fun toQuestion(questionString: String): QuestionEntity {
        return adapter.fromJson(questionString)!!
    }
}