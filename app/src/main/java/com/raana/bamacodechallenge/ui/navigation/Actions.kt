package com.raana.bamacodechallenge.ui.navigation

import androidx.navigation.NavHostController

class Actions(navController: NavHostController) {
    val navigateToSplash: () -> Unit = {
        navController.navigate(Screen.Splash.toString()) {
            popUpTo(Screen.Splash.toString()) { inclusive = true }
        }
    }

    val navigateToHome: () -> Unit = {
        navController.navigate(Screen.User.toString()) {
            popUpTo(Screen.User.toString()) { inclusive = true }
        }
    }
    val navigateToPost: () -> Unit = {
        navController.navigate(Screen.Post.toString()) {
            popUpTo(Screen.Post.toString()) { inclusive = true }
        }
    }

    val navigateToDetail: (id: String) -> Unit = { id: String ->
        navController.currentBackStackEntry?.arguments?.putString("id", id)
        navController.navigate("${Screen.Detail}/$id")
    }

    val backPress: () -> Unit = {
        navController.navigateUp()
    }
}