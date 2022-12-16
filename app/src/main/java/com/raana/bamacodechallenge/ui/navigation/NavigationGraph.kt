package com.raana.bamacodechallenge.ui.navigation

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raana.bamacodechallenge.ui.post.PostScreen
import com.raana.bamacodechallenge.ui.user.UserScreen
import kotlinx.coroutines.CoroutineScope


sealed class Screen(val route: String)  {
    object User : Screen("user")
    object Post : Screen("post")
    object Splash : Screen("splash"){}
    object Detail : Screen("detail")
    
}


@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Post.route,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
) {

    val actions = remember(navController) { Actions(navController) }

    NavHost(
        navController = navController, startDestination = startDestination
    ) {
        composable(Screen.Splash.route) {

        }
        composable(Screen.User.route) {
            UserScreen(coroutineScope = coroutineScope, viewModel = hiltViewModel())
        }
        composable(Screen.Post.route) {
            PostScreen(coroutineScope = coroutineScope, viewModel = hiltViewModel())
        }
        composable(
            "${Screen.Detail}/{id}",
        ) {

        }
    }

}

