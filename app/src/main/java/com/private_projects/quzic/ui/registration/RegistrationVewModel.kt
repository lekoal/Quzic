package com.private_projects.quzic.ui.registration

import android.content.Context
import androidx.lifecycle.ViewModel
import com.private_projects.quzic.data.entities.UserEntity
import com.private_projects.quzic.domain.QuizRepository
import com.private_projects.quzic.utils.PasswordHash
import com.private_projects.quzic.utils.UserDataSaveLocal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class RegistrationVewModel(
    private val quizRepository: QuizRepository
) : ViewModel() {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private val passwordCoder = PasswordHash()
    private val userDataSaveLocal = UserDataSaveLocal()

    fun addUser(name: String, password: String) {
        coroutineScope.launch {
            quizRepository.insertUser(
                UserEntity(
                    name = name,
                    passwordHash = passwordCoder.hash(password),
                    quizzes = null
                )
            )
        }
    }

    fun saveUserData(context: Context, name: String, password: String) {
        coroutineScope.launch {
            userDataSaveLocal.save(context, name, passwordCoder.hash(password))
        }
    }

    fun getUserData(context: Context): Flow<Set<String>> {
        return userDataSaveLocal.get(context)
    }

    override fun onCleared() {
        coroutineScope.cancel()
        super.onCleared()
    }
}