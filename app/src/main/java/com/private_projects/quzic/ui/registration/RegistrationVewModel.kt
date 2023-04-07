package com.private_projects.quzic.ui.registration

import androidx.lifecycle.ViewModel
import com.private_projects.quzic.data.entities.UserEntity
import com.private_projects.quzic.domain.QuizRepository
import com.private_projects.quzic.utils.PasswordHash
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class RegistrationVewModel(
    private val quizRepository: QuizRepository
): ViewModel() {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private val passwordCoder = PasswordHash()

    fun addUser(name: String, password: String) {
        val newPassword = passwordCoder.hash(password)
        coroutineScope.launch {
            quizRepository.insertUser(
                UserEntity(
                    name = name,
                    passwordHash = newPassword,
                    quizzes = null
                )
            )
        }
    }

    override fun onCleared() {
        coroutineScope.cancel()
        super.onCleared()
    }
}