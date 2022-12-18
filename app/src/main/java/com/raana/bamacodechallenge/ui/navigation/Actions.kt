package com.raana.bamacodechallenge.ui.navigation

import androidx.navigation.NavHostController

class Actions(navController: NavHostController) {
    val navigateToDetail: (id: Int) -> Unit = { id: Int ->
        navController.navigate("${Screen.Detail}/$id")
    }
}