package com.raana.bamacodechallenge.ui.navigation

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.raana.bamacodechallenge.ui.navigation.Screens.DETAIL_ROUTE
import com.raana.bamacodechallenge.ui.navigation.Screens.HOME_ROUTE
import com.raana.bamacodechallenge.ui.navigation.Screens.POST_ROUTE
import com.raana.bamacodechallenge.ui.navigation.Screens.SPLASH_ROUTE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.InternalCoroutinesApi


object Screens {
    const val SPLASH_ROUTE = "splash"
    const val HOME_ROUTE = "home"
    const val DETAIL_ROUTE = "detail"
    const val POST_ROUTE = "post"
}

@InternalCoroutinesApi
@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = SPLASH_ROUTE,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
) {

    val actions = remember(navController) { Actions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(SPLASH_ROUTE) {

        }
        composable(HOME_ROUTE) {

        }
        composable(POST_ROUTE) {

        }
        composable(
            "${DETAIL_ROUTE}/{id}",
        ) {

        }
    }

}

