package com.raana.bamacodechallenge.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
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
        ) {
            NavigationGraph(
                navController = navController,
                coroutineScope = coroutineScope,
                scaffoldState = scaffoldState
            )
        }
    }


}