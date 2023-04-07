package com.private_projects.quzic.di

import com.private_projects.quzic.data.QuizRepositoryImpl
import com.private_projects.quzic.data.database.QuizDatabase
import com.private_projects.quzic.domain.QuizRepository
import com.private_projects.quzic.ui.registration.RegistrationVewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val registrationKoinModule = module {
    single(named("quiz_database")) {
        QuizDatabase.getInstance(androidContext().applicationContext)
    }

    single<QuizRepository>(named("quiz_repository")) {
        QuizRepositoryImpl(get(named("quiz_database")))
    }

    scope<RegistrationVewModel> {
        scoped(named("registration_view_model")) {
            RegistrationVewModel(get(named("quiz_repository")))
        }
    }
}