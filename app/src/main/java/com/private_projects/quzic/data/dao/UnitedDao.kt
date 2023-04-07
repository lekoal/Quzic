package com.private_projects.quzic.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import com.private_projects.quzic.data.entities.UserEntity
import com.private_projects.quzic.data.entities.UserQuiz

@Dao
interface UnitedDao {
    @Transaction
    @Query("SELECT * FROM user WHERE id LIKE :userId")
    fun getUserData(userId: Long): UserQuiz

    @Transaction
    @Delete
    fun deleteUserData(userEntity: UserEntity)
}