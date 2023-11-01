package com.raana.composeSample.ui.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.raana.composeSample.ui.post.PostScreen
import com.raana.composeSample.ui.post_detail.PostDetailScreen
import com.raana.composeSample.ui.user.UserScreen


sealed class Screen(val route: String) {
    object User : Screen("user")
    object Post : Screen("post")
    object Detail : Screen("detail")
}


@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Post.route) {

    val actions = remember(navController) { Actions(navController) }

    NavHost(
        navController = navController, startDestination = startDestination
    ) {
        composable(Screen.User.route) {
            UserScreen(viewModel = hiltViewModel())
        }
        composable(Screen.Post.route) {
            PostScreen(
                viewModel = hiltViewModel(),
                navigateToDetail = actions.navigateToDetail
            )
        }
        composable(
            "${Screen.Detail}/{id}",
            arguments = listOf(
                navArgument("id") {
                    nullable = false
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt("id")?.let {
                PostDetailScreen(
                    viewModel = hiltViewModel(),
                    postId = it,
                )
            }

        }
    }

}

