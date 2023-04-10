package com.private_projects.quzic.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserDataSaveLocal {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_data")

    suspend fun save(context: Context, name: String, hash: String) {
        context.dataStore.edit { settings ->
            settings[PreferencesKeys.USER_DATA] = setOf(name, hash)
        }
    }

    fun get(context: Context): Flow<Set<String>> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.USER_DATA] ?: setOf("null", "null")
    }

}