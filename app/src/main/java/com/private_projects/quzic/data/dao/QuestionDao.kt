package com.private_projects.quzic.data.dao

import androidx.room.*
import com.private_projects.quzic.data.entities.QuestionEntity

@Dao
interface QuestionDao {
    @Query("SELECT * FROM question WHERE quiz_id LIKE :quizId")
    suspend fun getAllQuestions(quizId: Long): List<QuestionEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertQuestion(question: QuestionEntity)

    @Delete
    suspend fun deleteQuestion(question: QuestionEntity)
}