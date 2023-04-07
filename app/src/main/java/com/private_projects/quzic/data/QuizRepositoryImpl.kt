package com.private_projects.quzic.data

import com.private_projects.quzic.data.database.QuizDatabase
import com.private_projects.quzic.data.entities.QuestionEntity
import com.private_projects.quzic.data.entities.QuizEntity
import com.private_projects.quzic.data.entities.UserEntity
import com.private_projects.quzic.data.entities.UserQuiz
import com.private_projects.quzic.domain.QuizRepository

class QuizRepositoryImpl(private val quizDatabase: QuizDatabase) : QuizRepository {
    override suspend fun getAllUsers(): List<UserEntity> {
        return quizDatabase.userDao().getAllUsers()
    }

    override suspend fun getUser(userId: Long): UserEntity {
        return quizDatabase.userDao().getUser(userId)
    }

    override suspend fun insertUser(user: UserEntity) {
        quizDatabase.userDao().insertUser(user)
    }

    override suspend fun deleteUser(user: UserEntity) {
        quizDatabase.userDao().deleteUser(user)
    }

    override suspend fun getQuizzes(userId: Long): List<QuizEntity> {
        return quizDatabase.quizDao().getQuizzes(userId)
    }

    override suspend fun getQuiz(userId: Long, name: String): QuizEntity {
        return quizDatabase.quizDao().getQuiz(userId, name)
    }

    override suspend fun insertQuiz(quiz: QuizEntity) {
        quizDatabase.quizDao().insertQuiz(quiz)
    }

    override suspend fun deleteQuiz(quiz: QuizEntity) {
        quizDatabase.quizDao().deleteQuiz(quiz)
    }

    override suspend fun getAllQuestions(quizId: Long): List<QuestionEntity> {
        return quizDatabase.questionDao().getAllQuestions(quizId)
    }

    override suspend fun insertQuestion(question: QuestionEntity) {
        quizDatabase.questionDao().insertQuestion(question)
    }

    override suspend fun deleteQuestion(question: QuestionEntity) {
        quizDatabase.questionDao().deleteQuestion(question)
    }

    override suspend fun getAllUserData(userId: Long): UserQuiz {
        return quizDatabase.unitedDao().getUserData(userId)
    }

    override suspend fun deleteUserData(user: UserEntity) {
        quizDatabase.unitedDao().deleteUserData(user)
    }

}