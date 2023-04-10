package com.private_projects.quzic.utils.json

import androidx.room.TypeConverter
import com.private_projects.quzic.data.entities.QuestionEntity
import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class QuestionsConverter {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val adapter = ListJsonAdapter(moshi.adapter(QuestionEntity::class.java))

    @TypeConverter
    @ToJson
    fun toJson(question: List<QuestionEntity>?): String? {
        return adapter.toJson(question) ?: null
    }

    @TypeConverter
    @FromJson
    fun fromJson(questionString: String): List<QuestionEntity>? {
        return adapter.fromJson(questionString)
    }
}