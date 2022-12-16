package com.raana.bamacodechallenge.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.raana.bamacodechallenge.ui.component.AppBottomNavigationBar
import com.raana.bamacodechallenge.ui.navigation.NavigationGraph
import com.raana.bamacodechallenge.ui.theme.MyTheme
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@Composable
fun MyApp() {

    MyTheme {
        val navController = rememberNavController()
        val coroutineScope = rememberCoroutineScope()
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = {
                AppBottomNavigationBar(navController) {
                    navController.navigate(it.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        ) {
            NavigationGraph(
                navController = navController,
                coroutineScope = coroutineScope,
                scaffoldState = scaffoldState
            )
        }
    }
}