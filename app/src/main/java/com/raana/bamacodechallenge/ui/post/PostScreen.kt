package com.raana.bamacodechallenge.ui.post


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
import com.raana.bamacodechallenge.R
import com.raana.bamacodechallenge.ui.component.LoadingAnimation
import com.raana.bamacodechallenge.ui.component.MyTopAppBar
import com.raana.bamacodechallenge.ui.component.NetworkFailure

@Composable
fun PostScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    viewModel: PostViewModel,
    navigateToDetail: (Int) -> Unit
) {
    val state by viewModel.state.collectAsState()
    Scaffold(scaffoldState = scaffoldState, topBar = {
        MyTopAppBar(title = stringResource(id = R.string.post))
    }) {
        val swipeRefreshState = rememberSwipeRefreshState(false)
        SwipeRefresh(state = swipeRefreshState, onRefresh = {
            viewModel.getPosts()
        }) {
            when (state) {
                is PostScreenState.Success -> {
                    val currentState = state as PostScreenState.Success
                    LazyColumn {
                        itemsIndexed(currentState.posts) { _, post ->
                            PostItem(post) {
                                navigateToDetail(post.id)
                            }
                        }
                    }
                }
                is PostScreenState.Error -> {
                    val currentState = state as PostScreenState.Error
                    NetworkFailure(Modifier.fillMaxSize(),currentState.throwable.message){
                        viewModel.getPosts()
                    }
                }
                PostScreenState.Initial -> {

                }
                PostScreenState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                    ) {
                        LoadingAnimation()
                    }
                }
            }
        }
    }
}
