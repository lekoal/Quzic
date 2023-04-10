package com.private_projects.quzic.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.private_projects.quzic.data.dao.QuestionDao
import com.private_projects.quzic.data.dao.QuizDao
import com.private_projects.quzic.data.dao.UnitedDao
import com.private_projects.quzic.data.dao.UserDao
import com.private_projects.quzic.data.entities.QuestionEntity
import com.private_projects.quzic.data.entities.QuizEntity
import com.private_projects.quzic.data.entities.UserEntity
import com.private_projects.quzic.utils.json.QuestionsConverter
import com.private_projects.quzic.utils.json.QuizzesConverter

@Database(
    entities = [UserEntity::class, QuizEntity::class, QuestionEntity::class],
    version = 1
)
@TypeConverters(QuestionsConverter::class, QuizzesConverter::class)
abstract class QuizDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun quizDao(): QuizDao
    abstract fun questionDao(): QuestionDao
    abstract fun unitedDao(): UnitedDao

    companion object {
        private var instance: QuizDatabase? = null

        fun getInstance(context: Context): QuizDatabase {
            if (instance == null) {
                synchronized(QuizDatabase::class) {
                    instance = buildRoomDB(context)
                }
            }
            return instance!!
        }

        private fun buildRoomDB(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                QuizDatabase::class.java,
                "quiz.db"
            ).build()
    }
}