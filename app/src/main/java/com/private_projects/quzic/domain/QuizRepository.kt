package com.private_projects.quzic.domain

import com.private_projects.quzic.data.entities.QuizEntity
import com.private_projects.quzic.data.entities.QuestionEntity
import com.private_projects.quzic.data.entities.UserEntity
import com.private_projects.quzic.data.entities.UserQuiz

interface QuizRepository {
    //User
    suspend fun getAllUsers(): List<UserEntity>
    suspend fun getUser(userId: Long): UserEntity
    suspend fun insertUser(user: UserEntity)
    suspend fun deleteUser(user: UserEntity)

    //Quiz
    suspend fun getQuizzes(userId: Long): List<QuizEntity>
    suspend fun getQuiz(userId: Long, name: String): QuizEntity
    suspend fun insertQuiz(quiz: QuizEntity)
    suspend fun deleteQuiz(quiz: QuizEntity)

    //Question
    suspend fun getAllQuestions(quizId: Long): List<QuestionEntity>
    suspend fun insertQuestion(question: QuestionEntity)
    suspend fun deleteQuestion(question: QuestionEntity)

    //AllData
    suspend fun getAllUserData(userId: Long): UserQuiz
    suspend fun deleteUserData(user: UserEntity)
}