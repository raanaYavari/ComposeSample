package com.raana.bamacodechallenge.ui.post_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.raana.bamacodechallenge.R
import com.raana.bamacodechallenge.ui.component.LoadingAnimation
import com.raana.bamacodechallenge.ui.component.MyTopAppBar
import com.raana.bamacodechallenge.ui.post.PostItem
import com.raana.bamacodechallenge.ui.theme.red
import com.raana.bamacodechallenge.ui.theme.textColor
import kotlinx.coroutines.CoroutineScope

@Composable
fun PostDetailScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    coroutineScope: CoroutineScope,
    viewModel: PostDetailViewModel,
    postId: Int,
) {
    val state by viewModel.state.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.getPostDetail(postId)
    }
    Scaffold(scaffoldState = scaffoldState, topBar = {
        MyTopAppBar(stringResource(id = R.string.post_detail))
    }, snackbarHost = {
        SnackbarHost(hostState = it) {
            Snackbar(
                backgroundColor = red, contentColor = textColor, snackbarData = it
            )
        }
    }) {
        when (state) {
            is PostDetailScreenState.Error -> {

            }
            PostDetailScreenState.Initial -> {}
            PostDetailScreenState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    LoadingAnimation()
                }
            }
            is PostDetailScreenState.Success -> {
                val currentState = state as PostDetailScreenState.Success
                PostItem(post = currentState.post) {

                }
            }
        }
    }

}