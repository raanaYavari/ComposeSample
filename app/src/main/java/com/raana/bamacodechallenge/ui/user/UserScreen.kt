package com.raana.bamacodechallenge.ui.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.raana.bamacodechallenge.R
import com.raana.bamacodechallenge.domain.repository.user.model.User
import com.raana.bamacodechallenge.ui.component.LoadingAnimation
import com.raana.bamacodechallenge.ui.component.MyTopAppBar
import com.raana.bamacodechallenge.ui.component.NetworkFailure
import com.raana.bamacodechallenge.ui.post.PostItem
import com.raana.bamacodechallenge.ui.post.PostScreenState
import com.raana.bamacodechallenge.ui.theme.red
import com.raana.bamacodechallenge.ui.theme.surfaceColor
import com.raana.bamacodechallenge.ui.theme.textColor
import kotlinx.coroutines.CoroutineScope

@Composable
fun UserScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    viewModel: UserViewModel
) {
    val state by viewModel.state.collectAsState()

    Scaffold(scaffoldState = scaffoldState, topBar = {
        MyTopAppBar(title = stringResource(id = R.string.user))
    }, snackbarHost = {
        SnackbarHost(hostState = it) {
            Snackbar(
                backgroundColor = red, contentColor = textColor, snackbarData = it
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
                        itemsIndexed(currentState.users) { index, user ->
                            UserItem(user)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun UserItem(user: User) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = surfaceColor, shape = RoundedCornerShape(4.dp))
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp),
            text = user.name,
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp),
            text = user.phone,
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp),
            text = user.website,
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp),
            text = user.address.toString(),
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}