package com.private_projects.quzic.data.dao

import androidx.room.*
import com.private_projects.quzic.data.entities.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM user WHERE id LIKE :userId")
    suspend fun getUser(userId: Long): UserEntity

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insertUser(user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)
}