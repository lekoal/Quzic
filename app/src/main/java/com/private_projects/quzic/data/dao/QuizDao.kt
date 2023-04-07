package com.private_projects.quzic.data.dao

import androidx.room.*
import com.private_projects.quzic.data.entities.QuizEntity

@Dao
interface QuizDao {
    @Query("SELECT * FROM quiz WHERE owner_id LIKE :ownerId")
    suspend fun getQuizzes(ownerId: Long): List<QuizEntity>

    @Query("SELECT * FROM quiz WHERE owner_id LIKE :ownerId AND name LIKE :name")
    suspend fun getQuiz(ownerId: Long, name: String): QuizEntity

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insertQuiz(quiz: QuizEntity)

    @Delete
    suspend fun deleteQuiz(quiz: QuizEntity)
}