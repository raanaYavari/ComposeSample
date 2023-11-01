package com.raana.composeSample.ui.user

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.raana.composeSample.R
import com.raana.composeSample.ui.component.LoadingAnimation
import com.raana.composeSample.ui.component.MyTopAppBar
import com.raana.composeSample.ui.component.NetworkFailure
import com.raana.composeSample.ui.theme.red
import com.raana.composeSample.ui.theme.textColor

@Composable
fun UserScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    viewModel: UserViewModel
) {
    val state by viewModel.state.collectAsState()

    Scaffold(scaffoldState = scaffoldState, topBar = {
        MyTopAppBar(title = stringResource(id = R.string.user))
    }, snackbarHost = {
        SnackbarHost(hostState = it) {data->
            Snackbar(
                backgroundColor = red, contentColor = textColor, snackbarData = data
            )
        }
    }) {
        val swipeRefreshState = rememberSwipeRefreshState(false)
        SwipeRefresh(state = swipeRefreshState, onRefresh = {
            viewModel.getUsers()
        }) {
            when (state) {
                is UserViewModel.UserScreenState.Error -> {
                    val currentState = state as UserViewModel.UserScreenState.Error
                    NetworkFailure(Modifier.fillMaxSize(),currentState.throwable.message){
                        viewModel.getUsers()
                    }
                }
                UserViewModel.UserScreenState.Initial -> {

                }
                UserViewModel.UserScreenState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                    ) {
                        LoadingAnimation()
                    }
                }
                is UserViewModel.UserScreenState.Success -> {
                    val currentState = state as UserViewModel.UserScreenState.Success
                    LazyColumn {
                        itemsIndexed(currentState.users) { _, user ->
                            UserItem(user)
                        }
                    }
                }
            }
        }
    }
}
