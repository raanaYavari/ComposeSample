package com.raana.bamacodechallenge.ui.navigation

import androidx.navigation.NavHostController

class Actions(navController: NavHostController) {
    val navigateToSplash: () -> Unit = {
        navController.navigate(Screens.SPLASH_ROUTE) {
            popUpTo(Screens.SPLASH_ROUTE) { inclusive = true }
        }
    }

    val navigateToHome: () -> Unit = {
        navController.navigate(Screens.HOME_ROUTE) {
            popUpTo(Screens.SPLASH_ROUTE) { inclusive = true }
        }
    }
    val navigateToPost: () -> Unit = {
        navController.navigate(Screens.POST_ROUTE) {
            popUpTo(Screens.SPLASH_ROUTE) { inclusive = true }
        }
    }

    val navigateToDetail: (id: String) -> Unit = { id: String ->
        navController.currentBackStackEntry?.arguments?.putString("id", id)
        navController.navigate("${Screens.POST_ROUTE}/$id")
    }

    val backPress: () -> Unit = {
        navController.navigateUp()
    }
}