package com.private_projects.quzic.utils.json

import androidx.room.TypeConverter
import com.private_projects.quzic.data.entities.QuizEntity
import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class QuizzesConverter {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val adapter = ListJsonAdapter(moshi.adapter(QuizEntity::class.java))

    @TypeConverter
    @ToJson
    fun toJson(quizzes: List<QuizEntity>?): String? {
        return adapter.toJson(quizzes) ?: null
    }

    @TypeConverter
    @FromJson
    fun fromJson(quizzesString: String): List<QuizEntity>? {
        return adapter.fromJson(quizzesString)
    }
}