package com.private_projects.quzic.utils

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.private_projects.quzic.ui.AddQuizScreen
import com.private_projects.quzic.ui.LoginScreen
import com.private_projects.quzic.ui.MyQuizzesScreen
import com.private_projects.quzic.ui.registration.RegistrationScreen


@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "first_screen"
    ) {
        composable("first_screen") {
            MyQuizzesScreen(navController = navController)
        }
        composable(
            "second_screen"
        ) {
            AddQuizScreen(navController = navController)
        }
        composable("login_screen") {
            LoginScreen(navController = navController)
        }
        composable("registration_screen") {
            RegistrationScreen(navController = navController)
        }
    }
}